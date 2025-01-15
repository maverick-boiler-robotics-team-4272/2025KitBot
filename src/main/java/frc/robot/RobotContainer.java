// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.robot.constants.TunerConstants;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.subsystems.drivetrain.states.DriveState;
import frc.robot.subsystems.drivetrain.states.PathfindingState;
import frc.robot.subsystems.drivetrain.states.ResetState;
import frc.robot.subsystems.dropper.Dropper;
import frc.robot.subsystems.dropper.states.DropState;

import static frc.robot.constants.SubsystemConstants.DrivetrainConstants.TeleConstants.MAX_TRANSLATION;
import static frc.robot.constants.SubsystemConstants.LimeLightConstants.FRONT_LIMELIGHT;

public class RobotContainer {
    private ShuffleboardTab autoTab;
    private SendableChooser<Command> autoChooser;

    private final Telemetry logger = new Telemetry(MAX_TRANSLATION);

    private final CommandXboxController joystick = new CommandXboxController(0);

    public final CommandSwerveDrivetrain drivetrain = TunerConstants.createDrivetrain();
    public final Dropper dropper = new Dropper();

    public RobotContainer() {
        configureBindings();
        registerNamedCommands();
        setupAutos();
    }
        
    private void configureBindings() {
        // Note that X is defined as forward according to WPILib convention,
        // and Y is defined as to the left according to WPILib convention.
        drivetrain.setDefaultCommand(
            new DriveState(
                drivetrain, 
                joystick::getLeftY,
                joystick::getLeftX,
                joystick::getRightX
            )
        );

        // Run SysId routines when holding back/start and X/Y.
        // Note that each routine should be run exactly once in a single log.
        joystick.back().and(joystick.y()).whileTrue(drivetrain.sysIdDynamic(Direction.kForward));
        joystick.back().and(joystick.x()).whileTrue(drivetrain.sysIdDynamic(Direction.kReverse));
        joystick.start().and(joystick.y()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kForward));
        joystick.start().and(joystick.x()).whileTrue(drivetrain.sysIdQuasistatic(Direction.kReverse));

        // reset the field-centric heading on left bumper press
        joystick.b().onTrue(drivetrain.runOnce(() -> drivetrain.seedFieldCentric()));
        joystick.rightBumper().whileTrue(new DropState(dropper));

        joystick.a().whileTrue(new PathfindingState(drivetrain, new Pose2d(6, 4, new Rotation2d(0))));
        joystick.y().onTrue(new ResetState(drivetrain, FRONT_LIMELIGHT::getBotPose));

        drivetrain.registerTelemetry(logger::telemeterize);
    }

    private void registerNamedCommands() {
        NamedCommands.registerCommand("Drop", new DropState(dropper));
    }

    private void setupAutos() {
        autoChooser = new SendableChooser<>();
    
        autoTab = Shuffleboard.getTab("Auto");
        autoTab.add(autoChooser).withSize(2, 1);

        autoChooser.setDefaultOption("5 coral!!!", new PathPlannerAuto("5 coral!!!"));
    }

    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}


