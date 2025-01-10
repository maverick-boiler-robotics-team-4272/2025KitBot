package frc.robot.subsystems.dropper;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.constants.HardwareMap;
import frc.robot.utils.hardware.VortexBuilder;

public class Dropper implements Subsystem {
    

    private SparkFlex dropperMotor;

    

    public Dropper() {
        
        dropperMotor = VortexBuilder.create(HardwareMap.DROPPER_MOTOR_ID)
            .withCurrentLimit(80)
            .withVoltageCompensation(12)
            .withInversion(true)
            .build();
    }

    public void setPower(double power) {
        dropperMotor.set(power);
    }
}
