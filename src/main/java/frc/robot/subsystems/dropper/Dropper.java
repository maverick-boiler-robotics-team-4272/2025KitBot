package frc.robot.subsystems.dropper;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Subsystem;

public class Dropper implements Subsystem {
    SparkFlex dropperMotor;

    public Dropper() {
        dropperMotor = new SparkFlex(0, MotorType.kBrushless);
    }
}
