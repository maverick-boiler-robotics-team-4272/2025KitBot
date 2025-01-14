package frc.robot.subsystems.drivetrain.states;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveRequest.FieldCentric;
import com.ctre.phoenix6.swerve.SwerveRequest;

import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.utils.commandUtils.State;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static frc.robot.constants.TeleConstants.*;

public class DriveState extends State<CommandSwerveDrivetrain> {
    private DoubleSupplier xAxis;
    private DoubleSupplier yAxis;
    private DoubleSupplier theta;

    private FieldCentric request;

    public DriveState(CommandSwerveDrivetrain drivetrain, DoubleSupplier xSpeed, DoubleSupplier ySpeed, DoubleSupplier thetaSpeed) {
        super(drivetrain);

        this.xAxis = xSpeed;
        this.yAxis = ySpeed;
        this.theta = thetaSpeed;

        request = new SwerveRequest.FieldCentric()
            .withDeadband(MAX_TRANSLATION * 0.1).withRotationalDeadband(MAX_ANGULAR * 0.1) // Add a 10% deadband
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage);
    }

    @Override
    public void execute() {
        requiredSubsystem.setControl(
            request
                .withVelocityX(-xAxis.getAsDouble() * MAX_TRANSLATION)
                .withVelocityY(-yAxis.getAsDouble() * MAX_TRANSLATION)
                .withRotationalRate(-theta.getAsDouble() * MAX_ANGULAR)
        );
    }
}
