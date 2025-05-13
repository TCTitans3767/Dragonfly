package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class Drivetrain extends SubsystemBase {
    // Drivetrain class to control the robot's movement
    // This class will handle the motors and their configurations

    // motor variables
    private final SparkMax leftFront;
    private final SparkMax leftBack;
    private final SparkMax rightFront;
    private final SparkMax rightBack;

    // utils
    public final DifferentialDrive differentialDrive;

    // motor config
    SparkMaxConfig globalConfig = new SparkMaxConfig();
    SparkMaxConfig leftLeader = new SparkMaxConfig();
    SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
    SparkMaxConfig rightLeader = new SparkMaxConfig();
    SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();

    public Drivetrain() {

        // setting global config
        globalConfig.smartCurrentLimit(40);
        globalConfig.idleMode(IdleMode.kCoast);


        // left front
        leftFront = new SparkMax(2, MotorType.kBrushless);
        leftLeader.apply(globalConfig);
        leftLeader.inverted(true);

        // left back
        leftBack = new SparkMax(3, MotorType.kBrushless);
        leftFollowerConfig.apply(globalConfig);
        leftFollowerConfig.follow(leftFront);

        // right front
        rightFront = new SparkMax(4, MotorType.kBrushless);
        rightLeader.apply(globalConfig);

        // right back
        rightBack = new SparkMax(5, MotorType.kBrushless);
        rightFollowerConfig.apply(globalConfig);
        rightFollowerConfig.follow(rightFront);

        // differential drive
        differentialDrive = new DifferentialDrive(leftFront, rightFront);

        /*
         * come back to this
         * 
         * it is important
         * I also dont really understnad it
         * make sure everything is set to KBrushless
         */


        // asigning the motor configs
        leftFront.configure(globalConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftBack.configure(leftFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFront.configure(rightLeader, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightBack.configure(rightFollowerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        // Add code to update the drivetrain state here
    }

    // Drive methods
    public void arcadeDrive(double forwardSpeed, double turnSpeed) {
        differentialDrive.arcadeDrive(forwardSpeed, turnSpeed);
    }

}
