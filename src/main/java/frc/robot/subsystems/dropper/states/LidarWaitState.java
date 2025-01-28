package frc.robot.subsystems.dropper.states;

import frc.robot.subsystems.dropper.Dropper;
import frc.robot.utils.commandUtils.State;

public class LidarWaitState extends State<Dropper> {
    public LidarWaitState(Dropper dropper) {
        super(dropper);
    }

    @Override
    public boolean isFinished() {
        return requiredSubsystem.hasCoral();
    }
}
