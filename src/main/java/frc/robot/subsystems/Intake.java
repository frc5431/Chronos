package frc.robot.subsystems;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants.IntakeModes;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkBase.IdleMode;

public class Intake extends SubsystemBase {
    
    public CANSparkBase intakeMotor;
    public IntakeModes mode;

    public Intake(CANSparkBase intakeMotor){
        this.intakeMotor = intakeMotor;
        intakeMotor.setIdleMode(IdleMode.kCoast);


    }

    public void periodic(){
        SmartDashboard.putNumber("Intake", intakeMotor.getAppliedOutput());
    }


    public void runIntake(IntakeModes mode) {
        intakeMotor.set(-mode.speed);
    }
}
