package frc.robot.constants;

import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RotationsPerSecond;
import static frc.robot.constants.TunerConstants.kSpeedAt12Volts;

public class TeleConstants {
    public static final double MAX_TRANSLATION = kSpeedAt12Volts.in(MetersPerSecond);
    public static final double MAX_ANGULAR = RotationsPerSecond.of(0.75).in(RadiansPerSecond);
}
