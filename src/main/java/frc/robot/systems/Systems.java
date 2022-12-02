package frc.robot.systems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.systems.subsystems.GoodIntake;
import frc.robot.systems.subsystems.GoodShooter;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.components.Intake;
import frc.robot.components.Shooter;

public class Systems{
    
    private GoodIntake intake;

    private WPI_TalonSRX intakeMotor;

    private GoodShooter shooter;

    private WPI_TalonSRX shooterMotorR, shooterMotorL;
    

    public Systems(){
        intakeMotor = new WPI_TalonSRX(Constants.INTAKE_ID);
        intake = new GoodIntake(intakeMotor);
        shooterMotorL = new WPI_TalonSRX(Constants.LEFT_SHOOTER_ID);
        shooterMotorR = new WPI_TalonSRX(Constants.RIGHT_SHOOTER_ID);
        shooter = new GoodShooter(shooterMotorL, shooterMotorR);

    }
    
    
    public GoodIntake gIntake(){
        return intake;
    }
    public GoodShooter gShooter(){
        return shooter;
    }





}