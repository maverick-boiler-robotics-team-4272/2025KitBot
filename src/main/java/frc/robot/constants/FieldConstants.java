package frc.robot.constants;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class FieldConstants {
    public static final double FIELD_WIDTH_METERS = Meters.convertFrom(26.5, Feet);
    public static final double FIELD_LENGTH_METERS = Meters.convertFrom(57.5, Feet);

    public static boolean isRedSide() {
        if(DriverStation.getAlliance().get() == Alliance.Red){
            return true;
        }
        return false;
    }
}
