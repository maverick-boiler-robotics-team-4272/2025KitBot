package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.subsystems.drivetrain.states.PathfindingState;
import frc.robot.subsystems.dropper.Dropper;
import frc.robot.subsystems.dropper.states.LidarDropState;
import frc.robot.subsystems.dropper.states.LidarWaitState;

public class AutoTeleCommand extends SequentialCommandGroup {
    public AutoTeleCommand(CommandSwerveDrivetrain drivetrain, Dropper dropper, Supplier<Pose2d> scorePose, Supplier<Pose2d> feedPose) {
        super(
            new PathfindingState(drivetrain, scorePose),
            new LidarDropState(dropper),
            new PathfindingState(drivetrain, feedPose),
            new LidarWaitState(dropper)
        );
    }
}
