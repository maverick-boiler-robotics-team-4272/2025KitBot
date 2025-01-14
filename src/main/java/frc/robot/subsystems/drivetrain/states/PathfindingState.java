package frc.robot.subsystems.drivetrain.states;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.utils.commandUtils.State;

public class PathfindingState extends State<CommandSwerveDrivetrain> {
    private Command command;

    public PathfindingState(CommandSwerveDrivetrain drivetrain, Pose2d targetPose) {
        super(drivetrain);

        command = AutoBuilder.pathfindToPose(
            targetPose, 
            new PathConstraints(
                4.5,
                3,
                720,
                560
            )
        );
    }

    @Override
    public void initialize() {
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
