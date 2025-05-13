// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class ValveConstants {
    public static final double targetPressure = 60.0; // psi
    public static final long shootTime = 500; // millisseconds

    public static final int pneumaticHubID = 10; // ID for the Pneumatic Hub
    public static final int fillSolenoidID = 1; // ID for the fill solenoid
    public static final int shootSolenoidID = 2; // ID for the shoot solenoid
    public static final int pressureSensorID = 0; // ID for the pressure sensor
  }
}
