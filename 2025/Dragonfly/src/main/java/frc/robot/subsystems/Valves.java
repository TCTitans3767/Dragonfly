package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.ValveConstants;

public class Valves extends SubsystemBase {

    private final PneumaticHub pneumaticHub;
    private final Solenoid fillSolenoid, shootSolenoid;
    public boolean isFillOpen, isShootOpen, canFill;
    
    public Valves() {
        // Constructor for the Valves subsystem
        // Initialize any necessary components here
        this.pneumaticHub = new PneumaticHub(ValveConstants.pneumaticHubID);
        this.fillSolenoid = new Solenoid(PneumaticsModuleType.REVPH, ValveConstants.fillSolenoidID);
        this.shootSolenoid = new Solenoid(PneumaticsModuleType.REVPH, ValveConstants.shootSolenoidID);  
        this.isFillOpen = false;
        this.isShootOpen = false; 
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        // Add any periodic tasks for the Valves subsystem here
        if (this.getPressure() >= ValveConstants.targetPressure) {
            this.closeFill();
            this.canFill = false;
        } else {
            this.canFill = true;
        }
    }

    public double getPressure() {
        // Implement logic to get pressure from the valves
        // This could involve reading from sensors or other components
        return this.pneumaticHub.getPressure(ValveConstants.pressureSensorID);
    }

    public void openFill() {
        // Implement logic to open the fill valve
        // This could involve sending a command to a motor or actuator
        if (this.canFill && !this.isShootOpen) {
            this.fillSolenoid.set(true ^ !ValveConstants.isFillNC);
            this.isFillOpen = true;
        }
    }

    public void closeFill() {
        // Implement logic to close the fill valve
        // This could involve sending a command to a motor or actuator
        this.fillSolenoid.set(false ^ !ValveConstants.isFillNC);
        this.isFillOpen = false;
    }

    public void openShoot() {
        // Implement logic to open the shoot valve
        // This could involve sending a command to a motor or actuator
        if (!this.isFillOpen) {
            this.shootSolenoid.set(true ^ !ValveConstants.isShootNC);
            this.isShootOpen = true;
        }
    }

    public void closeShoot() {
        // Implement logic to close the shoot valve
        // This could involve sending a command to a motor or actuator
        this.shootSolenoid.set(false ^ !ValveConstants.isShootNC);
        this.isShootOpen = false;
    }
}
