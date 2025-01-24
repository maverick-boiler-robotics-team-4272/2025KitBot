package frc.robot.constants;

import static edu.wpi.first.units.Units.Inches;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.util.Units;
import frc.robot.utils.limelight.Limelight;

import static frc.robot.constants.TunerConstants.kSpeedAt12Volts;

public class SubsystemConstants {
    public static class DrivetrainConstants {
        public static  class AutoConstants {
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

        public class TeleConstants {
            public static final double MAX_TRANSLATION = kSpeedAt12Volts.in(MetersPerSecond);
            public static final double MAX_ANGULAR = RotationsPerSecond.of(0.75).in(RadiansPerSecond);
        }
    }

    public static class DropperConstants {
        
    }

    public static class LimeLightConstants {
        public static Pose3d FRONT_LIMELIGHT_POSE = new Pose3d(
            0.0,
            Units.inchesToMeters(9.177),
            Units.inchesToMeters(17.607),
            new Rotation3d(
                -15, 
                Rotation2d.fromDegrees(10).getRadians(),
                Rotation2d.fromDegrees(0).getRadians()
            )
        );
        public static Pose3d BACK_LIMELIGHT_POSE = new Pose3d(
            0.0,
            Units.inchesToMeters(-8.661),
            Units.inchesToMeters(17.897),
            new Rotation3d(
                -25, 
                Rotation2d.fromDegrees(10).getRadians(),
                Rotation2d.fromDegrees(180).getRadians()
            )
        );

        public static Limelight FRONT_LIMELIGHT = new Limelight("limelight-front");
        public static Limelight BACK_LIMELIGHT = new Limelight("limelight-back");
    }
}
