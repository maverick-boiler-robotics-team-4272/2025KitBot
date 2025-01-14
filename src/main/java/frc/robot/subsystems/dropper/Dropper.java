package frc.robot.subsystems.dropper;

import com.revrobotics.spark.SparkFlex;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.utils.hardware.VortexBuilder;
import frc.robot.utils.logging.Loggable;

import static frc.robot.constants.SubsystemConstants.DropperConstants.*;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

public class Dropper implements Subsystem, Loggable {
    @AutoLog
    public static class DropperInputs {
        public double dropperPower;
        public boolean lidarTripped;
    }

    DropperInputsAutoLogged inputs = new DropperInputsAutoLogged();
    
    private SparkFlex dropperMotor;
    private TimeOfFlight lidar = new TimeOfFlight(DROPPER_LIDAR_ID);

    public Dropper() {  
        dropperMotor = VortexBuilder.create(DROPPER_MOTOR_ID)
            .withCurrentLimit(80)
            .withVoltageCompensation(12)
            .withInversion(true)
            .build();

        inputs.dropperPower = 0.0;
        inputs.lidarTripped = false;
    }

    public void setPower(double power) {
        inputs.dropperPower = power;
        dropperMotor.set(power);
    }

    public boolean hasCoral() {
        return lidar.getRange() < 40;
    }

    @Override
    public void log(String subdirectory, String humanReadableName) {
        Logger.processInputs(subdirectory + "/" + humanReadableName, inputs);
    }

    @Override
    public void periodic() {
        inputs.lidarTripped = hasCoral();

        log("Subsytems", "Dropper");
    }
}
