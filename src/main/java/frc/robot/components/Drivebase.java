package frc.robot.components;

import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Drivebase {
    private final WPI_TalonSRX frontLeft, backLeft, frontRight, backRight;

    public Drivebase(){
        frontLeft = new WPI_TalonSRX(Constants.FRONT_LEFT_ID);
        frontLeft.setInverted(Constants.FRONT_LEFT_INVERTED);
        frontLeft.setNeutralMode(NeutralMode.Coast);

        backLeft = new WPI_TalonSRX(Constants.BACK_LEFT_ID);
        backLeft.setInverted(Constants.BACK_LEFT_INVERTED);
        backLeft.setNeutralMode(NeutralMode.Coast);
        
        frontRight = new WPI_TalonSRX(Constants.FRONT_RIGHT_ID);
        frontRight.setInverted(Constants.FRONT_RIGHT_INVERTED);
        frontRight.setNeutralMode(NeutralMode.Coast);
        
        backRight = new WPI_TalonSRX(Constants.BACK_RIGHT_ID);
        backRight.setInverted(Constants.BACK_RIGHT_INVERTED);
        backRight.setNeutralMode(NeutralMode.Coast);
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
}