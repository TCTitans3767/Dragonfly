package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends Command {
    private final Drivetrain drivetrain;
    private final Supplier<Double> forwardSpeed, turnSpeed;

    public ArcadeDrive(Supplier<Double> forwardSpeed, Supplier<Double> turnSpeed, Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        this.forwardSpeed = forwardSpeed;
        this.turnSpeed = turnSpeed;
        addRequirements(drivetrain);
    }
}
