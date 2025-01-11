
package frc.robot.subsystems.dropper.states;

import frc.robot.subsystems.dropper.Dropper;
import frc.robot.utils.commandUtils.State;

public class DropState extends State<Dropper> {

  public DropState(Dropper dropper) {
    super(dropper);
  }

  @Override
  public void initialize() {
    requiredSubsystem.setPower(1);
  }

  @Override
  public void end(boolean interrupted) {
      requiredSubsystem.setPower(0);
  }
}
