package frc.robot.components;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase{
    private final WPI_TalonSRX frontLeft, backLeft, frontRight, backRight;

    public static final double DEFAULT_SPEED = 1.0;
    public static final boolean REVERSE = false;
    public static final NeutralMode NEUTRALMODE = NeutralMode.Coast;

    public Drivebase(WPI_TalonSRX front_left, WPI_TalonSRX back_left, WPI_TalonSRX front_right, WPI_TalonSRX back_right){
        frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_ID);
        frontLeft.setInverted(Constants.FRONT_LEFT_INVERTED);
        frontLeft.setNeutralMode(NEUTRALMODE);

        backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_ID);
        backLeft.setInverted(Constants.BACK_LEFT_INVERTED);
        backLeft.setNeutralMode(NEUTRALMODE);
        
        frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_ID);
        frontRight.setInverted(Constants.FRONT_RIGHT_INVERTED);
        frontRight.setNeutralMode(NEUTRALMODE);
        
        backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_ID);
        backRight.setInverted(Constants.BACK_RIGHT_INVERTED);
        backRight.setNeutralMode(NEUTRALMODE);
    }

    public void driveLeft(final double val){
        frontLeft.set(val);
        backLeft.set(val);
    }

    public void driveRight(final double val){
        frontRight.set(val);
        backRight.set(val);
    }
    
    public void drive(final double left, final double right){
        driveLeft(left);
        driveRight(right);
    }

    // Based on arcade drive pseudocode pdf found on CD
    public void driveArcade(final double forward, final double turn) {
        double max = Math.abs(forward);
        if (Math.abs(turn) > max) 
            max = Math.abs(turn);
        
        double sum = forward + turn;
        double dif = forward - turn;

        if (forward > 0) {
            if (turn >= 0) {
                driveLeft(max);
                driveRight(dif);
            } else {
                driveLeft(sum);
                driveRight(max);
            }
        } else {
            if (turn >= 0) {
                driveLeft(sum);
                driveRight(-max);
            } else {
                driveLeft(-max);
                driveRight(dif);
            }
        }
    }

    public Command runDriveLeft(boolean reverse){
        return runDriveLeft(reverse ? -DEFAULT_SPEED : DEFAULT_SPEED);
    }

    public Command runDriveLeft(double speed){
        return new StartEndCommand(() -> this.driveLeft(speed), () -> this.driveLeft(0), this);
    }

    public Command runDriveRight(boolean reverse){
        return runDriveRight(reverse ? -DEFAULT_SPEED : DEFAULT_SPEED);
    }

    public Command runDriveRight(double speed){
        return new StartEndCommand(() -> this.driveRight(speed), () -> this.driveRight(0), this);
    }

    public Command runArcade(boolean reverse){
        return runDriveRight(reverse ? -DEFAULT_SPEED : DEFAULT_SPEED);
    }

    public Command runArcade(double speed, double turn){
        return new StartEndCommand(() -> this.driveArcade(speed, turn), () -> this.driveArcade(0, turn), this);
    }
}