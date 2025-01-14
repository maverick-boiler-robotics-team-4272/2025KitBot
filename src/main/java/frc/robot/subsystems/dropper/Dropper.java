package frc.robot.subsystems.dropper;

import com.revrobotics.spark.SparkFlex;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.utils.hardware.VortexBuilder;

import static frc.robot.constants.SubsystemConstants.DropperConstants.*;

public class Dropper implements Subsystem {
    
    private SparkFlex dropperMotor;
    TimeOfFlight lidar = new TimeOfFlight(DROPPER_LIDAR_ID);

    public Dropper() {  
        dropperMotor = VortexBuilder.create(DROPPER_MOTOR_ID)
            .withCurrentLimit(80)
            .withVoltageCompensation(12)
            .withInversion(true)
            .build();
    }

    public void setPower(double power) {
        dropperMotor.set(power);
    }

    public boolean hasCoral() {
        return lidar.getRange() < 40;
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Has Coral", hasCoral());
    }
}
