package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public final class Constants {

    //Talon SRX's
    public final static int FRONT_LEFT_ID = 2;
    public final static boolean FRONT_LEFT_INVERTED = false;

    public final static int BACK_LEFT_ID = 5;
    public final static boolean BACK_LEFT_INVERTED = false;
    
    public final static int LEFT_SHOOTER_ID = 4;
    public final static boolean LEFT_SHOOTER_INVERTED = true;

    public final static int INTAKE_ID = 3;
    public final static boolean INTAKE_INVERTED = false;

    public final static int RIGHT_SHOOTER_ID = 6;
    public final static boolean RIGHT_SHOOTER_INVERTED = false;

    public final static int BACK_RIGHT_ID = 9;
    public final static boolean BACK_RIGHT_INVERTED = true;

    public final static int FRONT_RIGHT_ID = 8;
    public final static boolean FRONT_RIGHT_INVERTED = true;

    public final static double INTAKE_SPEED = 1.0;

    //Drivers
    public final static int DRIVER_JOYSTICK_ID = 0;
    public final static int OPERATOR_JOYSTICK_ID = 1;
    public final static double DRIVER_JOYSTICK_DEADZONE = 0.2;
}