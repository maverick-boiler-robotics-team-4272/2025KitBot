
package frc.robot.subsystems.dropper.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.dropper.Dropper;

public class DropState extends Command {

  Dropper dropper;

  public DropState(Dropper dropper) {
    this.dropper = dropper;
    addRequirements(dropper);
  }

  @Override
  public void initialize() {
    dropper.setPower(1);
  }
  
  @Override
  public boolean isFinished() {
    return false;
  }
}
