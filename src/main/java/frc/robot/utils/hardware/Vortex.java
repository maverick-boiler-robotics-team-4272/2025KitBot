package frc.robot.utils.hardware;

import com.revrobotics.spark.SparkFlex;

public class Vortex extends SparkFlex {
    public Vortex(int id) {
        super(id, MotorType.kBrushless);
    }
}
