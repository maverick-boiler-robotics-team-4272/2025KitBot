package frc.robot.subsystems.drivetrain.states;

import java.util.function.Supplier;

import edu.wpi.first.math.geometry.Pose2d;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.utils.commandUtils.State;

public class ResetState extends State<CommandSwerveDrivetrain> {
    private Supplier<Pose2d> pose;

    public ResetState(CommandSwerveDrivetrain drivetrain, Supplier<Pose2d> pose) {
        super(drivetrain);
        this.pose = pose;
    }

    @Override
    public void initialize() {
        requiredSubsystem.resetPose(pose.get());
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
