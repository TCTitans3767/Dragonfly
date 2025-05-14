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
        this.pneumaticHub = new PneumaticHub(ValveConstants.pneumaticHubID);
        this.fillSolenoid = new Solenoid(PneumaticsModuleType.REVPH, ValveConstants.fillSolenoidID);
        this.shootSolenoid = new Solenoid(PneumaticsModuleType.REVPH, ValveConstants.shootSolenoidID);  
        this.isFillOpen = false;
        this.isShootOpen = false; 

        this.closeFill();
        this.closeShoot();
    }

    @Override
    public void periodic() {
        if (this.getPressure() >= ValveConstants.targetPressure) {
            this.closeFill();
            this.canFill = false;
        } else {
            this.canFill = true;
        }
    }

    public double getPressure() {
        return this.pneumaticHub.getPressure(ValveConstants.pressureSensorID);
    }

    public void openFill() {
        // if (this.canFill && !this.isShootOpen) {
        //     this.fillSolenoid.set(true ^ !ValveConstants.isFillNC);
        //     this.isFillOpen = true;
        // }
        this.fillSolenoid.set(true);
    }

    public void closeFill() {
        // this.fillSolenoid.set(false ^ !ValveConstants.isFillNC);
        // this.isFillOpen = false;
        this.fillSolenoid.set(false);
    }

    public void openShoot() {
        if (!this.isFillOpen) {
            this.shootSolenoid.set(true ^ !ValveConstants.isShootNC);
            this.isShootOpen = true;
        }
    }

    public void closeShoot() {
        this.shootSolenoid.set(false ^ !ValveConstants.isShootNC);
        this.isShootOpen = false;
    }
}
