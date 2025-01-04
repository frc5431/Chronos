// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkBase.ControlType;

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
    public static final int leftBID = 3;
    public static final int rightBID = 4;
    public static final int leftFID = 5;
    public static final int rightFID = 6;

  }


  public static class IntakeConstants {

    public static final int id = 62;  

    public static final double intakeSpeed = 0.5;
    public static final double outakeSpeed = -0.3;

    public enum IntakeModes {
      INTAKE(intakeSpeed),
      OUTAKE(outakeSpeed),
      NONE(0);

      public double speed;

      IntakeModes(double speed) {
        this.speed = speed;
      }
    }
    }

    public static class ShooterConstants {

      public static final int leftID = 7;
      public static final int rightID = 8;

      public static final double p = 1;
      public static final double i = 0;
      public static final double d = 0.1;
      public static final double OutputRangeMin = -1;
      public static final double OutputRangeMax = 1;
      public static final ControlType shooterControl = ControlType.kVelocity;
      public static final double rightShootRPM = 8000;
      public static final double leftShootRPM = 1;

      public enum ShooterModes {
        SHOOT(rightShootRPM, leftShootRPM),
        REVERSE(-1000, -0.5),
        NONE(0, 0);

        public double leftRPM;
        public double rightRPM;

        ShooterModes(double rightRPM, double leftRPM) {
          this.leftRPM = leftRPM;
          this.rightRPM = rightRPM;
        }
      }
    }
  }

