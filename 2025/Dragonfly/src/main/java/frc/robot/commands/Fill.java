package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Valves;


public class Fill extends Command {
    private final Valves valves;
    private final double targetPressure;

    private long testTime;

    public Fill(Valves valves, double targetPressure) {
        this.valves = valves;
        this.targetPressure = targetPressure;
        addRequirements(valves);
    }

    @Override
    public void initialize() {
        // Open the fill valve to start filling
        // if (!valves.isFillOpen && !valves.isShootOpen) {
        //     valves.openFill();
        // }
        valves.openFill();
        // testTime = System.currentTimeMillis();
    }

    @Override
    public void execute() {
        // Check the current pressure and close the fill valve if the target is reached
        // if (valves.getPressure() >= targetPressure) {
        //     valves.closeFill();
        //     end(true);
        // }
        if (System.currentTimeMillis() - testTime >= Constants.ValveConstants.shootTime) {
            // valves.closeFill();
        }
    }

    @Override
    public boolean isFinished() {
        // return valves.getPressure() >= targetPressure;
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        // Ensure the fill valve is closed when the command ends
        // valves.closeFill();
    }
    
}
