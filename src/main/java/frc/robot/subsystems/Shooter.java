package frc.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants.ShooterModes;

public class Shooter extends SubsystemBase {
    public ShooterModes modes;
    
    public CANSparkBase shooterLeft;
    public CANSparkBase shooterRight;


    public Shooter(CANSparkBase shooterLeft, CANSparkBase shooterRight) {
        this.shooterLeft = shooterLeft;
        this.shooterRight = shooterRight;
        shooterLeft.setIdleMode(IdleMode.kCoast);
        shooterRight.setIdleMode(IdleMode.kCoast);

    }
    
    public void periodic(){
        SmartDashboard.putNumber("Shooter", shooterLeft.getAppliedOutput());
    }

    public void shoot(ShooterModes mode) {
        shooterLeft.set(mode.leftRPM);
        shooterRight.set(-mode.leftRPM);
    }

    
    
}
