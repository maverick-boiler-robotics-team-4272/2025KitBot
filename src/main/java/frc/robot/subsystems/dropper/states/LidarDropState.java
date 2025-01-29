package frc.robot.subsystems.dropper.states;

import frc.robot.subsystems.dropper.Dropper;
import frc.robot.utils.commandUtils.State;

public class LidarDropState extends State<Dropper> {
    public LidarDropState(Dropper dropper) {
        super(dropper);
    }

    @Override
    public void initialize() {
        requiredSubsystem.setPower(0.25);
    }

    @Override
    public boolean isFinished() {
        return !requiredSubsystem.hasCoral();
    }

    @Override
    public void end(boolean interrupted) {
        requiredSubsystem.setPower(0.0);
    }
}
