// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine.Direction;
import frc.robot.commands.AutoTeleCommand;
import frc.robot.constants.TunerConstants;
import frc.robot.subsystems.drivetrain.CommandSwerveDrivetrain;
import frc.robot.subsystems.drivetrain.states.DriveState;
import frc.robot.subsystems.drivetrain.states.ResetHeadingState;
import frc.robot.subsystems.dropper.Dropper;
import frc.robot.subsystems.dropper.states.DropState;

import static frc.robot.constants.FieldConstants.SIDE_CHOOSER;
import static frc.robot.constants.FieldConstants.getGlobalPositions;
import static frc.robot.constants.SubsystemConstants.DrivetrainConstants.TeleConstants.MAX_TRANSLATION;

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
        joystick.b().onTrue(new ResetHeadingState(drivetrain));
        joystick.rightBumper().whileTrue(new DropState(dropper));

        // joystick.a().whileTrue(new PathfindingState(drivetrain, getGlobalPositions().CORAL_STATION_LEFT));
        // joystick.y().whileTrue(new PathfindingState(drivetrain, getGlobalPositions().CORAL_EF));
        
        joystick.a().whileTrue(
            new AutoTeleCommand(drivetrain, dropper, () -> drivetrain.getNextScorePose(), () -> drivetrain.getNextFeedPose()).repeatedly() 
        );

        if(!Robot.isReal()) {
            drivetrain.registerTelemetry(logger::telemeterize);
        }

        configureButtons();
    }

    private void configureButtons() {
        var buttonTab = Shuffleboard.getTab("Buttons");
        
        buttonTab.add("AB", new InstantCommand(() -> drivetrain.setNextScorePose(getGlobalPositions().CORAL_AB)).ignoringDisable(true));
        buttonTab.add("CD", new InstantCommand(() -> drivetrain.setNextScorePose(getGlobalPositions().CORAL_CD)).ignoringDisable(true));
        buttonTab.add("EF", new InstantCommand(() -> drivetrain.setNextScorePose(getGlobalPositions().CORAL_EF)).ignoringDisable(true));
        buttonTab.add("GH", new InstantCommand(() -> drivetrain.setNextScorePose(getGlobalPositions().CORAL_GH)).ignoringDisable(true));
        buttonTab.add("IJ", new InstantCommand(() -> drivetrain.setNextScorePose(getGlobalPositions().CORAL_IJ)).ignoringDisable(true));
        buttonTab.add("KL", new InstantCommand(() -> drivetrain.setNextScorePose(getGlobalPositions().CORAL_KL)).ignoringDisable(true));

        buttonTab.add("Left", new InstantCommand(() -> drivetrain.setNextFeedPose(getGlobalPositions().CORAL_STATION_LEFT)).ignoringDisable(true));
        buttonTab.add("Right", new InstantCommand(() -> drivetrain.setNextFeedPose(getGlobalPositions().CORAL_STATION_RIGHT)).ignoringDisable(true));
    }

    private void registerNamedCommands() {
        NamedCommands.registerCommand("Drop", new DropState(dropper).withTimeout(0.5));
    }

    private void setupAutos() {
        autoChooser = new SendableChooser<>();

        SIDE_CHOOSER.setDefaultOption("Red", "red");
        SIDE_CHOOSER.addOption("Blue", "blue");
    
        autoTab = Shuffleboard.getTab("Auto");
        autoTab.add("AutoChooser", autoChooser);
        autoTab.add("SideChooser", SIDE_CHOOSER);

        autoChooser.setDefaultOption("5 coral!!!", new PathPlannerAuto("Top Side Auto"));
    }

    public Command getAutonomousCommand() {
        return autoChooser.getSelected();
    }
}
