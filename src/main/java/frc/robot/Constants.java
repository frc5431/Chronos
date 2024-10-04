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
  public static class ManipulatorConstants {
    public static final int leftManipulatorID = 1; // temp
    public static final int rightManipulatorID = 2; // temp

    public static final double intakeSpeed = -1; // temp
    public static final double shooterSpeed = -1; // temp
  }
  public static class DrivebaseConstants {
    public static final int leftID = 3;
    public static final int rightID = 4;

  }
}
