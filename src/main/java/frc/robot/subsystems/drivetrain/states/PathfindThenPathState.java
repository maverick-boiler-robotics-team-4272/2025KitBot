package frc.robot.subsystems.drivetrain.states;

import java.util.function.Supplier;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.SubsystemConstants.DrivetrainConstants.AutoConstants;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.utils.commandUtils.State;

public class PathfindThenPathState extends State<CommandSwerveDrivetrain> {
    Supplier<PathPlannerPath> pathSupplier;
    Command command;

    public PathfindThenPathState(CommandSwerveDrivetrain drivetrain, Supplier<PathPlannerPath> pathSupplier) {
        super(drivetrain);

        this.pathSupplier = pathSupplier;
    }

    public PathfindThenPathState(CommandSwerveDrivetrain drivetrain, PathPlannerPath path) {
        this(drivetrain, () -> path);
    }

    @Override
    public void initialize() {
        this.command = AutoBuilder.pathfindThenFollowPath(
            pathSupplier.get(),
            new PathConstraints(
                AutoConstants.TRANSLATION_MAX,
                AutoConstants.TRANSLATION_MAX_A,
                AutoConstants.ROTATION_MAX.getDegrees(),
                AutoConstants.ROTATION_MAX_A.getDegrees()
            )
        );
    }
}
