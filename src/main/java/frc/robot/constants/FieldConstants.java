package frc.robot.constants;

import static edu.wpi.first.units.Units.*;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

public class FieldConstants {
    public static final double FIELD_WIDTH_METERS = Meters.convertFrom(26.5, Feet);
    public static final double FIELD_LENGTH_METERS = Meters.convertFrom(57.5, Feet);
    public static final SendableChooser<String> SIDE_CHOOSER = new SendableChooser<>();

    public static final PositionContainer RED_POSITIONS = new PositionContainer(true);
    public static final PositionContainer BLUE_POSITIONS = new PositionContainer(false);

    public static PositionContainer getGlobalPositions() {
        return isRedSide() ? RED_POSITIONS : BLUE_POSITIONS;
    }

    public static boolean isRedSide() {
        if(SIDE_CHOOSER.getSelected() == "red"){
            return true;
        }
        return false;
    }
}
