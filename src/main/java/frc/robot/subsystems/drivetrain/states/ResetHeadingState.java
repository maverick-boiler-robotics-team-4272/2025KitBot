package frc.robot.subsystems.drivetrain.states;

import static frc.robot.constants.FieldConstants.isRedSide;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.utils.commandUtils.State;

public class ResetHeadingState extends State<CommandSwerveDrivetrain> {
    public ResetHeadingState(CommandSwerveDrivetrain drivetrain) {
        super(drivetrain);
    }

    @Override
    public void initialize() {
        Pose2d currentPose = new Pose2d(requiredSubsystem.getState().Pose.getTranslation(), Rotation2d.fromDegrees(isRedSide() ? 180 : 0));
        requiredSubsystem.resetPose(currentPose);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
