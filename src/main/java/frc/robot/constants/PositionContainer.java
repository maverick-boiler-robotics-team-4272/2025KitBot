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
		CORAL_GH = new Pose2d(red ? 11.6568 : FIELD_LENGTH_METERS - 11.6568, red ? 3.9949 : FIELD_WIDTH_METERS - 3.9949, red ? Rotation2d.fromDegrees(0) : Rotation2d.fromDegrees(180));
		CORAL_IJ = new Pose2d(red ? 12.3947 : FIELD_LENGTH_METERS - 12.3947, red ? 2.7835 : FIELD_WIDTH_METERS - 2.7835, red ? Rotation2d.fromDegrees(60) : Rotation2d.fromDegrees(-120));
		CORAL_KL = new Pose2d(red ? 13.8387 : FIELD_LENGTH_METERS - 13.8387, red ? 2.7835 : FIELD_WIDTH_METERS - 2.7835, red ? Rotation2d.fromDegrees(120) : Rotation2d.fromDegrees(-60));
		CORAL_AB = new Pose2d(red ? 14.4788 : FIELD_LENGTH_METERS - 14.4788, red ? 4.0200 : FIELD_WIDTH_METERS - 4.0200, red ? Rotation2d.fromDegrees(180) : Rotation2d.fromDegrees(0));
		CORAL_CD = new Pose2d(red ? 13.7508 : FIELD_LENGTH_METERS - 13.7508, red ? 5.1967 : FIELD_WIDTH_METERS - 5.1967, red ? Rotation2d.fromDegrees(-120) : Rotation2d.fromDegrees(60));
		CORAL_EF = new Pose2d(red ? 12.3448 : FIELD_LENGTH_METERS - 12.3448, red ? 5.1867 : FIELD_WIDTH_METERS - 5.1867, red ? Rotation2d.fromDegrees(-60) : Rotation2d.fromDegrees(120));
		CORAL_STATION_LEFT = new Pose2d(red ? 16.2337 : FIELD_LENGTH_METERS - 16.2337, red ? 7.0514 : FIELD_WIDTH_METERS - 7.0514, red ? Rotation2d.fromDegrees(-126) : Rotation2d.fromDegrees(55));
		CORAL_STATION_RIGHT = new Pose2d(red ? 16.3534 : FIELD_LENGTH_METERS - 16.3534, red ? 1.0385 : FIELD_WIDTH_METERS - 1.0385, red ? Rotation2d.fromDegrees(126) : Rotation2d.fromDegrees(-55));

        //Stop Precomputed positions here
    }
}
