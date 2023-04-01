package frc.robot.components;

import javax.swing.GroupLayout.ParallelGroup;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.Constants;

public class Shooter{
    private final WPI_TalonSRX m_rightShooter, m_leftShooter;

    public Shooter(){
        m_rightShooter = new WPI_TalonSRX(Constants.RIGHT_SHOOTER_ID);
        m_rightShooter.setInverted(Constants.RIGHT_SHOOTER_INVERTED);
        m_rightShooter.setNeutralMode(NeutralMode.Coast);

        m_leftShooter = new WPI_TalonSRX(Constants.LEFT_SHOOTER_ID);
        m_leftShooter.setInverted(Constants.LEFT_SHOOTER_INVERTED);
        m_leftShooter.setNeutralMode(NeutralMode.Coast);
        
    }

    public WPI_TalonSRX rightShooter(){
        return m_rightShooter;
    }

    public WPI_TalonSRX leftShooter(){
        return m_leftShooter;
    }

    public void set(double speed) {
        leftShooter().set(ControlMode.PercentOutput, speed);
    }

    public Command runShooterCommand(WPI_TalonSRX requestedMotor, double speed) {
        return new StartEndCommand(() -> requestedMotor.set(speed), () -> requestedMotor.setNeutralMode(NeutralMode.Coast));
    }

    public Command shoot(WPI_TalonSRX requestedMotor, double speed){
       return parallel(runShooterCommand(leftShooter(), 2));
    }



    // public RunCommand shootRight(){
    //     return rightShooter.set(Constants.SHOOT_SPEED);
    // }

    // public ParallelCommandGroup shoot(){
    //     return ;
    
        
    // }
}