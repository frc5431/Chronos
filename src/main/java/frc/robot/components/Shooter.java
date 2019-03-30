package frc.robot.components;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

public class Shooter{
    private final WPI_TalonSRX rightShooter, leftShooter;

    public Shooter(){
        rightShooter = new WPI_TalonSRX(Constants.RIGHT_SHOOTER_ID);
        rightShooter.setInverted(Constants.RIGHT_SHOOTER_INVERTED);

        leftShooter = new WPI_TalonSRX(Constants.LEFT_SHOOTER_ID);
        leftShooter.setInverted(Constants.LEFT_SHOOTER_INVERTED);
    }

    public void shooter(final double val){
        rightShooter.set(val);
        leftShooter.set(val);
    }
}