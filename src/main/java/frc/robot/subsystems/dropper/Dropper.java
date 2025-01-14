package frc.robot.subsystems.dropper;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.playingwithfusion.TimeOfFlight;

import frc.robot.utils.hardware.VortexBuilder;
import frc.robot.utils.logging.Loggable;

import static frc.robot.constants.SubsystemConstants.DropperConstants.*;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

public class Dropper extends SubsystemBase implements Loggable {
    @AutoLog
    public static class DropperInputs {
        public double dropperPower;
        public boolean lidarTripped;
        public double lidarDistance;
    }

    DropperInputsAutoLogged inputs = new DropperInputsAutoLogged();
    
    private SparkFlex dropperMotor;
    private TimeOfFlight lidar = new TimeOfFlight(DROPPER_LIDAR_ID);

    public Dropper() {  
        dropperMotor = VortexBuilder.create(DROPPER_MOTOR_ID)
            .withCurrentLimit(80)
            .withVoltageCompensation(12)
            .withInversion(true)
            .withIdleMode(IdleMode.kBrake)
            .build();

        inputs.dropperPower = 0.0;
        inputs.lidarTripped = false;
        inputs.lidarDistance = 0.0;
    }

    public void setPower(double power) {
        inputs.dropperPower = power;
        dropperMotor.set(power);
    }

    public boolean hasCoral() {
        return lidar.getRange() < 100;
    }

    @Override
    public void log(String subdirectory, String humanReadableName) {
        Logger.processInputs(subdirectory + "/" + humanReadableName, inputs);
    }

    @Override
    public void periodic() {
        inputs.lidarTripped = hasCoral();
        inputs.lidarDistance = lidar.getRange();

        log("Subsystems", "Dropper");
    }
}
