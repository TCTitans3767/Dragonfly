package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Valves;


public class Fill extends Command {
    private final Valves valves;
    private final double targetPressure;

    public Fill(Valves valves, double targetPressure) {
        this.valves = valves;
        this.targetPressure = targetPressure;
        addRequirements(valves);
    }

    @Override
    public void initialize() {
        // Open the fill valve to start filling
        if (!valves.isFillOpen && !valves.isShootOpen) {
            valves.openFill();
        }
    }

    @Override
    public void execute() {
        // Check the current pressure and close the fill valve if the target is reached
        if (valves.getPressure() >= targetPressure) {
            valves.closeFill();
            end(true);
        }
    }

    @Override
    public boolean isFinished() {
        return valves.getPressure() >= targetPressure;
    }

    @Override
    public void end(boolean interrupted) {
        // Ensure the fill valve is closed when the command ends
        valves.closeFill();
    }
    
}
