package frc.robot.subsystems;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants.IntakeModes;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

public class Intake extends SubsystemBase {
    
    public SparkMax intakeMotor;
    public SparkMaxConfig intakeMotorConfig;
    public IntakeModes mode;

    public Intake(SparkMax intakeMotor){
        this.intakeMotor = intakeMotor;
        intakeMotorConfig.idleMode(IdleMode.kCoast);
    }

    public void periodic(){
        SmartDashboard.putNumber("Intake", intakeMotor.getAppliedOutput());
    }


    public void runIntake(IntakeModes mode) {
        intakeMotor.set(-mode.speed);
    }
}
