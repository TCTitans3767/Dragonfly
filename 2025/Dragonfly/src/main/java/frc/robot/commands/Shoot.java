package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Valves;
import frc.robot.Constants.ValveConstants;

public class Shoot extends Command {
    private final Valves valves;
    private final long startTime;

    private boolean activated = false;

    public Shoot(Valves valves, boolean activated) {
        this.activated = activated;
        this.valves = valves;
        this.startTime = System.currentTimeMillis();
        addRequirements(valves);
    }

    @Override
    public void initialize() {
        // Open the shoot valve to start shooting
        if (!valves.isShootOpen && !valves.isFillOpen && activated) {
            valves.openShoot();
        }
    }

    @Override
    public void execute() {
        // Check if target time has passed
        if (activated && valves.isShootOpen) {
            if (System.currentTimeMillis() - startTime >= ValveConstants.shootTime) {
                // Close the shoot valve after the target time
                valves.closeShoot();
                end(true);
            }
        }
    }

    @Override
    public boolean isFinished() {
        return System.currentTimeMillis() - startTime >= ValveConstants.shootTime;
    }

    @Override
    public void end(boolean interrupted) {
        // Ensure the shoot valve is closed when the command ends
        valves.closeShoot();
    }
}
