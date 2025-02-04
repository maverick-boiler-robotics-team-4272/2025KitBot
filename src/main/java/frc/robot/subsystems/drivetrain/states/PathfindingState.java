package frc.robot.subsystems.drivetrain.states;

import java.util.function.Supplier;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.SubsystemConstants.DrivetrainConstants.AutoConstants;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.utils.commandUtils.State;

public class PathfindingState extends State<CommandSwerveDrivetrain> {
    private Command command;
    private Supplier<Pose2d> pose;

    public PathfindingState(CommandSwerveDrivetrain drivetrain, Pose2d targetPose) {
        super(drivetrain);

        pose = () -> targetPose;
    }

    public PathfindingState(CommandSwerveDrivetrain drivetrain, Supplier<Pose2d> targetPose) {
        super(drivetrain);

        pose = targetPose;
    }

    @Override
    public void initialize() {
        command = AutoBuilder.pathfindToPose(
            pose.get(), 
            new PathConstraints(
                AutoConstants.TRANSLATION_MAX,
                AutoConstants.TRANSLATION_MAX_A,
                AutoConstants.ROTATION_MAX.getDegrees(),
                AutoConstants.ROTATION_MAX_A.getDegrees()
            )
        );

        command.initialize();
    }

    @Override
    public void execute() {
        command.execute();
    }

    @Override
    public boolean isFinished() {
        return command.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        command.end(interrupted);
    }
}
