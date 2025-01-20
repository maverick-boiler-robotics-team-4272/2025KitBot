package frc.robot.utils.hardware;

// Hardware
import com.revrobotics.*;
import com.revrobotics.CANPIDController;

public class NeoBuilder {
    private Neo motor;
    private CANPIDController motorController;
    private RelativeEncoder motorEncoder;

    private NeoBuilder(int id) {
        motor = new Neo(id);
        motor.restoreFactoryDefaults();
    }

    public NeoBuilder asFollower(CANSparkMax motor, boolean inverted) {
        this.motor.follow(motor, inverted);

        return this;
    }

    public NeoBuilder withVoltageCompensation(int nominalVoltage) {
        motor.enableVoltageCompensation(nominalVoltage);

        return this;
    }

    public NeoBuilder withCurrentLimit(int currentLimit) {
        motor.setSmartCurrentLimit(currentLimit);

        return this;
    }

    public NeoBuilder withIdleMode(IdleMode mode) {
        motor.setIdleMode(mode);

        return this;
    }

    public NeoBuilder withInversion(boolean inverted) {
        motor.setInverted(inverted);

        return this;
    }

    public NeoBuilder withPIDParams(double p, double i, double d) {
        if(motorController == null)
            motorController = motor.getPIDController();

        motorController.setP(p);
        motorController.setI(i);
        motorController.setD(d);

        return this;
    }

    public NeoBuilder withPIDFParams(double p, double i, double d, double f) {
        if(motorController == null)
            motorController = motor.getPIDController();

        motorController.setP(p);
        motorController.setI(i);
        motorController.setD(d);
        motorController.setFF(f);

        return this;
    }

    public NeoBuilder withPIDClamping(double min, double max) {
        if(motorController == null)
            motorController = motor.getPIDController();

        motorController.setOutputRange(min, max);

        return this;
    }

    public NeoBuilder withMaxIAccum(double max) {
        if(motorController == null)
            motorController = motor.getPIDController();

        motorController.setIMaxAccum(max, 0);
        return this;
    }

    public NeoBuilder withPositionConversionFactor(double factor) {
        if(motorEncoder == null)
            motorEncoder = motor.getEncoder();
        
        motorEncoder.setPositionConversionFactor(factor);

        return this;
    }

    public NeoBuilder withPosition(double position) {
        if(motorEncoder == null)
            motorEncoder = motor.getEncoder();

        motorEncoder.setPosition(position);

        return this;
    }

    public NeoBuilder withVelocityConversionFactor(double factor) {
        if(motorEncoder == null)
            motorEncoder = motor.getEncoder();

        motorEncoder.setVelocityConversionFactor(factor);

        return this;
    }

    public NeoBuilder withForwardSoftlimit(double limit) {
        motor.enableSoftLimit(SoftLimitDirection.kForward, true);
        motor.setSoftLimit(SoftLimitDirection.kForward, (float)limit);

        return this;
    }

    public NeoBuilder withReverseSoftLimit(double limit) {
        motor.enableSoftLimit(SoftLimitDirection.kReverse, true);
        motor.setSoftLimit(SoftLimitDirection.kReverse, (float)limit);

        return this;
    }

    public NeoBuilder withSoftLimits(double forwardLimit, double reverseLimit) {
        motor.enableSoftLimit(SoftLimitDirection.kForward, true);
        motor.enableSoftLimit(SoftLimitDirection.kReverse, true);

        motor.setSoftLimit(SoftLimitDirection.kForward, (float)forwardLimit);
        motor.setSoftLimit(SoftLimitDirection.kReverse, (float)reverseLimit);

        return this;
    }

    public NeoBuilder withOutputRange(double min, double max) {
        if(motorController == null)
            motorController = motor.getPIDController();

        motorController.setOutputRange(min, max);

        return this;
    }

    public NeoBuilder withClosedLoopRampRate(double rate) {
        motor.setClosedLoopRampRate(rate);

        return this;
    }

    public NeoBuilder withOpenLoopRampRate(double rate) {
        motor.setOpenLoopRampRate(rate);

        return this;
    }

    public NeoBuilder withPIDPositionWrapping(double min, double max) {
        if(motorController == null)
            motorController = motor.getPIDController();

        motorController.setPositionPIDWrappingEnabled(true);
        motorController.setPositionPIDWrappingMaxInput(max);
        motorController.setPositionPIDWrappingMinInput(min);

        return this;
    }

    /**
     * 
     * 
     * <p>Status Frame 0: Applied Set, Faults, Sticky Faults, Is Follower, Default: 10ms</p>
     * <p>Status Frame 1: Motor Velocity, Motor Temperature, Motor Voltage, Motor Current, Default: 20ms</p>
     * <p>Status Frame 2: Motor Position, Default: 20ms</p>
     * <p>Status Frame 3: Analog Sensor Voltage, Analog Sensor Velocity, Analog Sensor Position, Default: 50ms</p>
     * <p>Status Frame 4: Alternate Encoder Velocity, Alternate Encoder Position, Default: 20ms</p>
     * <p>Status Frame 5: Duty Cycle Absolute Encoder Position, Default: 200ms</p>
     * <p>Status Frame 6: Duty Cycle Absolute Encoder Velocity, Default: 500ms</p>
     * @param frame which frame you wish to set
     * @param ms period time in milliseconds
     */
    public NeoBuilder withPeriodicFramerate(PeriodicFrame frame, int ms) {
        motor.setPeriodicFramePeriod(frame, ms);

        return this;
    }

    public Neo build() {
        motor.burnFlash();
        return motor;
    }

    public Neo getUnburntVortex() {
        return motor;
    }

    public static NeoBuilder create(int id) {
        return new NeoBuilder(id);
    }
}