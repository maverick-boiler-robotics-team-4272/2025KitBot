package frc.robot.constants;

import edu.wpi.first.math.geometry.*;


import static frc.robot.constants.FieldConstants.*;

public class PositionContainer {
    public final Pose2d CORAL_AB;
    public final Pose2d CORAL_CD;
    public final Pose2d CORAL_EF;
    public final Pose2d CORAL_GH;
    public final Pose2d CORAL_IJ;
    public final Pose2d CORAL_KL;

    public final Pose2d CORAL_STATION_LEFT;
    public final Pose2d CORAL_STATION_RIGHT;

    public PositionContainer(boolean red) {
        //Variable = new Pose2d(red ? FIELD_LENGTH_METERS - x : x, y, red ? Rotation2d.fromDegrees(red degrees) : Rotation2d.fromDegrees(blue Degrees))
        //Insert Precomputed positions here
		CORAL_GH = new Pose2d(red ? 11.2542 : FIELD_LENGTH_METERS - 11.2542, red ? 3.9799 : FIELD_WIDTH_METERS - 3.9799, red ? Rotation2d.fromDegrees(0) : Rotation2d.fromDegrees(180));
		CORAL_IJ = new Pose2d(red ? 12.0506 : FIELD_LENGTH_METERS - 12.0506, red ? 2.4323 : FIELD_WIDTH_METERS - 2.4323, red ? Rotation2d.fromDegrees(60) : Rotation2d.fromDegrees(-120));
		CORAL_KL = new Pose2d(red ? 13.9589 : FIELD_LENGTH_METERS - 13.9589, red ? 2.5375 : FIELD_WIDTH_METERS - 2.5375, red ? Rotation2d.fromDegrees(120) : Rotation2d.fromDegrees(-60));
		CORAL_AB = new Pose2d(red ? 14.8153 : FIELD_LENGTH_METERS - 14.8153, red ? 3.9649 : FIELD_WIDTH_METERS - 3.9649, red ? Rotation2d.fromDegrees(180) : Rotation2d.fromDegrees(0));
		CORAL_CD = new Pose2d(red ? 14.0190 : FIELD_LENGTH_METERS - 14.0190, red ? 5.6327 : FIELD_WIDTH_METERS - 5.6327, red ? Rotation2d.fromDegrees(-120) : Rotation2d.fromDegrees(60));
		CORAL_EF = new Pose2d(red ? 12.1558 : FIELD_LENGTH_METERS - 12.1558, red ? 5.5426 : FIELD_WIDTH_METERS - 5.5426, red ? Rotation2d.fromDegrees(-60) : Rotation2d.fromDegrees(120));
		CORAL_STATION_LEFT = new Pose2d(red ? 16.3329 : FIELD_LENGTH_METERS - 16.3329, red ? 0.9898 : FIELD_WIDTH_METERS - 0.9898, red ? Rotation2d.fromDegrees(126) : Rotation2d.fromDegrees(-55));
		CORAL_STATION_RIGHT = new Pose2d(red ? 16.3179 : FIELD_LENGTH_METERS - 16.3179, red ? 7.1053 : FIELD_WIDTH_METERS - 7.1053, red ? Rotation2d.fromDegrees(-126) : Rotation2d.fromDegrees(55));

        //Stop Precomputed positions here
    }
}
