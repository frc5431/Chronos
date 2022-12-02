package frc.robot.systems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.systems.subsystems.GoodIntake;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.components.Intake;

public class Systems{
    
    private GoodIntake intake;

    private WPI_TalonSRX intakeMotor;

    public Systems(){

        intakeMotor = new WPI_TalonSRX(Constants.INTAKE_ID);

        intake = new GoodIntake(intakeMotor);

    }


    public GoodIntake gIntake(){

        return intake;

    }






}