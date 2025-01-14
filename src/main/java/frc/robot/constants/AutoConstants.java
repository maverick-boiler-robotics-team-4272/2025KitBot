package frc.robot.constants;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;


public class AutoConstants {
    public static final double TRANSLATION_MAX = 4.5;
    public static final double TRANSLATION_MAX_A = 4.0;
    public static final double DRIVEBASE_RADIUS = Units.inchesToMeters(13.27709);
    public static final Rotation2d ROTATION_MAX = Rotation2d.fromDegrees(560.0);
    public static final Rotation2d ROTATION_MAX_A = Rotation2d.fromDegrees(720.0);

    public static final double TRANSLATION_P = 10.0;
    public static final double TRANSLATION_I = 0.0;
    public static final double TRANSLATION_D = 0.0;

    public static final double ROTATION_P = 10.0;
    public static final double ROTATION_I = 0.0;
    public static final double ROTATION_D = 0.0;
}