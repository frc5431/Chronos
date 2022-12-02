package frc.robot.components;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase{

    private WPI_TalonSRX rightShooter, leftShooter;

    public static final double DEFAULT_SPEED = 1.0;
    public static final boolean REVERSE = false;
    public static final NeutralMode NEUTRALMODE = NeutralMode.Coast;

    public Shooter(WPI_TalonSRX leftMotor, WPI_TalonSRX rightMotor){

        leftShooter = leftMotor;
        rightShooter = rightMotor;

        rightShooter = new WPI_TalonSRX(Constants.RIGHT_SHOOTER_ID);
        rightShooter.setInverted(Constants.RIGHT_SHOOTER_INVERTED);
        rightShooter.setNeutralMode(NeutralMode.Coast);

        leftShooter = new WPI_TalonSRX(Constants.LEFT_SHOOTER_ID);
        leftShooter.setInverted(Constants.LEFT_SHOOTER_INVERTED);
        leftShooter.setNeutralMode(NeutralMode.Coast);
    }

    public void shooter(final double val){
        rightShooter.set(val);
        leftShooter.set(val);
    }

    public Command runShooterCommand(boolean reverse){
        return runShooterCommand(reverse ? -DEFAULT_SPEED : DEFAULT_SPEED);
    }

    public Command runShooterCommand(double speed){
        return new StartEndCommand(() -> shooter(speed), () -> shooter(0), this);
    }

}