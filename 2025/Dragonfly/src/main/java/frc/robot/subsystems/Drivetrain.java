package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkMaxConfig;
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

    // motor config
    SparkMaxConfig globalConfig = new SparkMaxConfig();
    SparkMaxConfig leftConfig = new SparkMaxConfig();
    SparkMaxConfig leftFollowerConfig = new SparkMaxConfig();
    SparkMaxConfig rightConfig = new SparkMaxConfig();
    SparkMaxConfig rightFollowerConfig = new SparkMaxConfig();

    public Drivetrain() {

        globalConfig.smartCurrentLimit(40);
        globalConfig.idleMode(IdleMode.kCoast);


        // left front
        leftFront = new SparkMax(2, MotorType.kBrushless);
        leftConfig.apply(globalConfig);
        leftConfig.inverted(true);

        // left back
        leftBack = new SparkMax(3, MotorType.kBrushless);
        leftFollowerConfig.apply(globalConfig);
        leftFollowerConfig.follow(leftFront);

        // right front
        rightFront = new SparkMax(4, MotorType.kBrushless);
        rightConfig.apply(globalConfig);

        // right back
        rightBack = new SparkMax(5, MotorType.kBrushless);
        rightFollowerConfig.apply(globalConfig);
        rightFollowerConfig.follow(rightFront);

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        // Add code to update the drivetrain state here
    }

}
