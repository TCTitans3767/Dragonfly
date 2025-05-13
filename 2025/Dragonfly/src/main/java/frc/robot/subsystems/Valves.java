package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Valves extends SubsystemBase {
    
    public Valves() {
        // Constructor for the Valves subsystem
        // Initialize any necessary components here
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        // Add any periodic tasks for the Valves subsystem here
    }

    public double getPressure() {
        // Implement logic to get pressure from the valves
        // This could involve reading from sensors or other components
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
