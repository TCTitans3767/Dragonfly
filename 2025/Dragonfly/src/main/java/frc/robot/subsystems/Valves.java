package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.ValveConstants;

public class Valves extends SubsystemBase {

    private final PneumaticHub pneumaticHub;
    private final Solenoid fillSolenoid, shootSolenoid;
    
    public Valves() {
        // Constructor for the Valves subsystem
        // Initialize any necessary components here
        this.pneumaticHub = new PneumaticHub(ValveConstants.pneumaticHubID);
        this.fillSolenoid = new Solenoid(PneumaticsModuleType.REVPH, ValveConstants.fillSolenoidID);
        this.shootSolenoid = new Solenoid(PneumaticsModuleType.REVPH, ValveConstants.shootSolenoidID);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        // Add any periodic tasks for the Valves subsystem here
    }

    public double getPressure() {
        // Implement logic to get pressure from the valves
        // This could involve reading from sensors or other components
        this.pneumaticHub.getPressure(ValveConstants.pressureSensorID);
    }

    public bool isFillOpen() {
        // Implement logic to check if the fill valve is open
        // This could involve reading from sensors or other components
    }

    public bool isShootOpen() {
        // Implement logic to check if the shoot valve is open
        // This could involve reading from sensors or other components
    }

    public void openFill() {
        // Implement logic to open the fill valve
        // This could involve sending a command to a motor or actuator
    }

    public void closeFill() {
        // Implement logic to close the fill valve
        // This could involve sending a command to a motor or actuator
    }

    public void openShoot() {
        // Implement logic to open the shoot valve
        // This could involve sending a command to a motor or actuator
    }

    public void closeShoot() {
        // Implement logic to close the shoot valve
        // This could involve sending a command to a motor or actuator
    }
}
