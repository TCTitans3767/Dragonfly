// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.ValveConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Fill;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Valves;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  public final Drivetrain drivetrain = new Drivetrain();
  public final Valves valves = new Valves();

  public final Joystick driver = new Joystick(0);


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.b().onTrue(new Fill(valves, ValveConstants.targetPressure));
    m_driverController.rightTrigger().onTrue(new Shoot(valves, m_driverController.a().getAsBoolean()));
  }

  /*
   * double check this
   * 
  */

  public void setDefaltCommands() {
    drivetrain.setDefaultCommand(new ArcadeDrive(() -> -driver.getRawAxis(0), () -> -driver.getRawAxis(1), drivetrain));
  }
}