package frc.robot.subsystems;


import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants.IntakeModes;

public class Intake extends SubsystemBase {
    
    public SparkBase intakeMotor;
    public IntakeModes mode;
     SparkMaxConfig config = new SparkMaxConfig();

    public Intake(SparkBase intakeMotor){
        this.intakeMotor = intakeMotor;
        config.idleMode(IdleMode.kCoast);

        intakeMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    public void periodic(){
        SmartDashboard.putNumber("Intake", intakeMotor.getAppliedOutput());
    }


    public void runIntake(IntakeModes mode) {
        intakeMotor.set(-mode.speed);
    }
}
