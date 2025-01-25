package frc.robot.utils.hardware;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.Logger;

import com.revrobotics.spark.SparkFlex;

import frc.robot.utils.logging.Loggable;

public class Vortex extends SparkFlex implements Loggable {
    @AutoLog
    public static class VortexInputs {
        public double current;
        public double temperature;
        public double rotations;
        public double volts;
    }

    VortexInputsAutoLogged inputs = new VortexInputsAutoLogged();

    public Vortex(int id) {
        super(id, MotorType.kBrushless);
    }

    public void log(String subdirectory, String humanReadableName) {
        inputs.current = getOutputCurrent();
        inputs.rotations = getEncoder().getPosition();
        inputs.temperature = getMotorTemperature();
        inputs.volts = getBusVoltage();

        Logger.processInputs(subdirectory + "/" + humanReadableName, inputs);
    }
}
