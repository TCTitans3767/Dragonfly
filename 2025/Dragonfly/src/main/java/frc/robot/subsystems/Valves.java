package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import frc.robot.Constants.ValveConstants;

public class Valves extends SubsystemBase {

    private final PneumaticHub pneumaticHub;
    public final Solenoid fillSolenoid, shootSolenoid;
    public static boolean isFillOpen, isShootOpen, canFill;
    // get rid of static maybe
    
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
        /* 
         * the way we are doing get pressure might be wrong but idk why it isn't mad at us
         * also copilot auto completing comments is helarious
        */
        if (this.getPressure() >= ValveConstants.targetPressure) {
            this.closeFill();
            this.canFill = false;
        } else {
            this.canFill = true;
        }
    }

    /*
     * I think this is expacting an analog sensor
     * is the sensor analog or digital?
     */
    public double getPressure() {
        return this.pneumaticHub.getPressure(ValveConstants.pressureSensorID);
    }

    public void openFill() {
        if (this.canFill && !this.isShootOpen) {
            this.fillSolenoid.set(true ^ !ValveConstants.isFillNC);
            this.isFillOpen = true;
        }
        SmartDashboard.putString("fill", "true");
        this.fillSolenoid.set(true);
    }

    public void closeFill() {
        this.fillSolenoid.set(false ^ !ValveConstants.isFillNC);
        this.isFillOpen = false;
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
