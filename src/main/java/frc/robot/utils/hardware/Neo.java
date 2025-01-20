package frc.robot.utils.hardware;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

import com.revrobotics.CANSparkMax;

import frc.robot.utils.logging.Loggable;

public class Neo extends CANSparkMax implements Loggable {
    @AutoLog
    public static class NeoInputs {
        double voltage;
        double current;
    }

    NeoInputsAutoLogged inputs = new NeoInputsAutoLogged();

    public Neo(int id) {
        super(id, MotorType.kBrushless);

        inputs.voltage = 0.0;
        inputs.current = 0.0;
    }

    @Override
    public void log(String subdirectory, String humanReadableName) {
        inputs.voltage = getBusVoltage();
        inputs.current = getOutputCurrent();

        Logger.processInputs(subdirectory + "/" + humanReadableName, inputs);
    }
}