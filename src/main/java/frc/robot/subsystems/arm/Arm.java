package frc.robot.subsystems.arm;

import static frc.robot.constants.HardwareMap.*;
import frc.robot.utils.hardware.Neo;
import frc.robot.utils.hardware.NeoBuilder;


public class Arm {
    public Neo armMotor;
    public Arm() {
        armMotor = new NeoBuilder(1)
            .withVoltageCompensation(12)
            .withCurrentLimit(40)
            .withIdleMode(IdleMode.kBrake)
            .withPIDParams(0.1, 0.0, 0.0)
            .build();
    }a
    public Neo liftMotor;


    public void initializeLiftMotor() {
        liftMotor = new NeoBuilder(2)
            .withVoltageCompensation(12)
            .withCurrentLimit(40)
            .withIdleMode(IdleMode.kBrake)
            .withPIDParams(0.1, 0.0, 0.0)
            .build();
    }
}
