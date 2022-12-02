package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.components.*;

public class Systems {
    
    WPI_TalonSRX intake_motor;
    
    WPI_TalonSRX shooter_left;
    WPI_TalonSRX shooter_right;

    WPI_TalonSRX drive_front_left;
    WPI_TalonSRX drive_front_right;
    
    WPI_TalonSRX drive_back_left;
    WPI_TalonSRX drive_back_right;

    Drivebase drivebase;
    Intake intake;
    Shooter shooter;

    public Systems(){

        intake_motor = new WPI_TalonSRX(Constants.INTAKE_ID);

        shooter_left = new WPI_TalonSRX(Constants.LEFT_SHOOTER_ID);
        shooter_right = new WPI_TalonSRX(Constants.RIGHT_SHOOTER_ID);

        drive_front_left = new WPI_TalonSRX(Constants.FRONT_LEFT_ID);
        drive_back_right = new WPI_TalonSRX(Constants.FRONT_RIGHT_ID);

        drive_back_left = new WPI_TalonSRX(Constants.BACK_LEFT_ID);
        drive_back_right = new WPI_TalonSRX(Constants.BACK_RIGHT_ID);

        intake = new Intake(intake_motor);

        shooter = new Shooter(shooter_left, shooter_right);

        drivebase = new Drivebase(drive_front_left, drive_front_right, drive_back_left, drive_back_right);
        
    }

    public Intake getIntake(){

        return intake;

    }

    public WPI_TalonSRX getIntakeMotor(){

        return intake_motor;

    }

    public Shooter getShooter(){

        return shooter;

    }

    public WPI_TalonSRX getShooterLeft(){

        return shooter_left;

    }

    public WPI_TalonSRX getShooterRight(){

        return shooter_right;

    }
    
    public Drivebase getDrivebase(){

        return drivebase;

    }


}