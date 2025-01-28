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
        CORAL_AB = new Pose2d(red ? FIELD_LENGTH_METERS - 2.855 : 2.855, 3.995, red ? Rotation2d.fromDegrees(180) : Rotation2d.fromDegrees(0));
        CORAL_CD = new Pose2d(red ? FIELD_LENGTH_METERS - 3.681 : 3.681, 2.643,  red ? Rotation2d.fromDegrees(120) : Rotation2d.fromDegrees(60));
        CORAL_EF = new Pose2d(red ? FIELD_LENGTH_METERS - 5.364 : 5.364, 2.643, red ? Rotation2d.fromDegrees(60) : Rotation2d.fromDegrees(120));
        CORAL_GH = new Pose2d(red ? FIELD_LENGTH_METERS - 6.1 : 6.1, 3.995, red ? Rotation2d.fromDegrees(0) : Rotation2d.fromDegrees(180));
        CORAL_IJ = new Pose2d(red ? FIELD_LENGTH_METERS - 5.364 : 5.364, 5.407, red ? Rotation2d.fromDegrees(-60) : Rotation2d.fromDegrees(-120));
        CORAL_KL = new Pose2d(red ? FIELD_LENGTH_METERS - 3.681 : 3.681, 5.407, red ? Rotation2d.fromDegrees(-120) : Rotation2d.fromDegrees(-60));

        CORAL_STATION_LEFT = new Pose2d(red ? FIELD_LENGTH_METERS - 1.277 : 1.277, 1, red ? Rotation2d.fromDegrees(126) : Rotation2d.fromDegrees(55));
        CORAL_STATION_RIGHT = new Pose2d(red ? FIELD_LENGTH_METERS - 1.277 : 1.277, 7.015, red ? Rotation2d.fromDegrees(-126) : Rotation2d.fromDegrees(-55));
    }
}
