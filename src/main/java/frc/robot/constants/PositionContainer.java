package frc.robot.constants;

import edu.wpi.first.math.geometry.*;


import static frc.robot.constants.FieldConstants.*;

import com.pathplanner.lib.path.PathPlannerPath;

public class PositionContainer {
    public final Pose2d CORAL_AB;
    public final Pose2d CORAL_CD;
    public final Pose2d CORAL_EF;
    public final Pose2d CORAL_GH;
    public final Pose2d CORAL_IJ;
    public final Pose2d CORAL_KL;

    public final Pose2d CORAL_STATION_LEFT;
    public final Pose2d CORAL_STATION_RIGHT;

    public final PathPlannerPath CORAL_A;
    public final PathPlannerPath CORAL_B;
    public final PathPlannerPath CORAL_C;
    public final PathPlannerPath CORAL_D;
    public final PathPlannerPath CORAL_E;
    public final PathPlannerPath CORAL_F;
    public final PathPlannerPath CORAL_G;
    public final PathPlannerPath CORAL_H;
    public final PathPlannerPath CORAL_I;
    public final PathPlannerPath CORAL_J;
    public final PathPlannerPath CORAL_K;
    public final PathPlannerPath CORAL_L;

    public PositionContainer(boolean red) {
        //Variable = new Pose2d(red ? FIELD_LENGTH_METERS - x : x, y, red ? Rotation2d.fromDegrees(red degrees) : Rotation2d.fromDegrees(blue Degrees))
        //Insert Precomputed positions here
		CORAL_GH = new Pose2d(red ? 11.2542 : FIELD_LENGTH_METERS - 11.2542, red ? 3.9799 : FIELD_WIDTH_METERS - 3.9799, red ? Rotation2d.fromDegrees(0) : Rotation2d.fromDegrees(180));
		CORAL_IJ = new Pose2d(red ? 12.1107 : FIELD_LENGTH_METERS - 12.1107, red ? 2.5525 : FIELD_WIDTH_METERS - 2.5525, red ? Rotation2d.fromDegrees(60) : Rotation2d.fromDegrees(-120));
		CORAL_KL = new Pose2d(red ? 13.9589 : FIELD_LENGTH_METERS - 13.9589, red ? 2.5375 : FIELD_WIDTH_METERS - 2.5375, red ? Rotation2d.fromDegrees(120) : Rotation2d.fromDegrees(-60));
		CORAL_AB = new Pose2d(red ? 14.8153 : FIELD_LENGTH_METERS - 14.8153, red ? 3.9649 : FIELD_WIDTH_METERS - 3.9649, red ? Rotation2d.fromDegrees(180) : Rotation2d.fromDegrees(0));
		CORAL_CD = new Pose2d(red ? 13.9138 : FIELD_LENGTH_METERS - 13.9138, red ? 5.5426 : FIELD_WIDTH_METERS - 5.5426, red ? Rotation2d.fromDegrees(-120) : Rotation2d.fromDegrees(60));
		CORAL_EF = new Pose2d(red ? 12.1558 : FIELD_LENGTH_METERS - 12.1558, red ? 5.5426 : FIELD_WIDTH_METERS - 5.5426, red ? Rotation2d.fromDegrees(-60) : Rotation2d.fromDegrees(120));
		CORAL_STATION_LEFT = new Pose2d(red ? 16.3329 : FIELD_LENGTH_METERS - 16.3329, red ? 0.9898 : FIELD_WIDTH_METERS - 0.9898, red ? Rotation2d.fromDegrees(126) : Rotation2d.fromDegrees(-55));
		CORAL_STATION_RIGHT = new Pose2d(red ? 16.3179 : FIELD_LENGTH_METERS - 16.3179, red ? 7.1053 : FIELD_WIDTH_METERS - 7.1053, red ? Rotation2d.fromDegrees(-126) : Rotation2d.fromDegrees(55));

        //Stop Precomputed positions here

        try {
            CORAL_A = !isRedSide() ? PathPlannerPath.fromPathFile("Find A").flipPath() : PathPlannerPath.fromPathFile("Find A");
            CORAL_B = !isRedSide() ? PathPlannerPath.fromPathFile("Find B").flipPath() : PathPlannerPath.fromPathFile("Find B");
            CORAL_C = !isRedSide() ? PathPlannerPath.fromPathFile("Find C").flipPath() : PathPlannerPath.fromPathFile("Find C");
            CORAL_D = !isRedSide() ? PathPlannerPath.fromPathFile("Find D").flipPath() : PathPlannerPath.fromPathFile("Find D");
            CORAL_E = !isRedSide() ? PathPlannerPath.fromPathFile("Find E").flipPath() : PathPlannerPath.fromPathFile("Find E");
            CORAL_F = !isRedSide() ? PathPlannerPath.fromPathFile("Find F").flipPath() : PathPlannerPath.fromPathFile("Find F");
            CORAL_G = !isRedSide() ? PathPlannerPath.fromPathFile("Find G").flipPath() : PathPlannerPath.fromPathFile("Find G");
            CORAL_H = !isRedSide() ? PathPlannerPath.fromPathFile("Find H").flipPath() : PathPlannerPath.fromPathFile("Find H");
            CORAL_I = !isRedSide() ? PathPlannerPath.fromPathFile("Find I").flipPath() : PathPlannerPath.fromPathFile("Find I");
            CORAL_J = !isRedSide() ? PathPlannerPath.fromPathFile("Find J").flipPath() : PathPlannerPath.fromPathFile("Find J");
            CORAL_K = !isRedSide() ? PathPlannerPath.fromPathFile("Find K").flipPath() : PathPlannerPath.fromPathFile("Find K");
            CORAL_L = !isRedSide() ? PathPlannerPath.fromPathFile("Find L").flipPath() : PathPlannerPath.fromPathFile("Find L");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
