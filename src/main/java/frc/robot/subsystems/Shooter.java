package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants.ShooterModes;

public class Shooter extends SubsystemBase {
    public ShooterModes modes;
    
    public SparkBase shooterLeft;
    public SparkBase shooterRight;
    public SparkBaseConfig shooterLeftConfig;
    public SparkBaseConfig shooterRightConfig;


    public Shooter(SparkBase shooterLeft, SparkBase shooterRight) {
        this.shooterLeft = shooterLeft;
        this.shooterRight = shooterRight;
        shooterLeftConfig.idleMode(IdleMode.kCoast);
        shooterRightConfig.idleMode(IdleMode.kCoast);
        shooterLeft.configure(shooterLeftConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        shooterRight.configure(shooterRightConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        
    }
    
    public void periodic(){
        SmartDashboard.putNumber("Shooter", shooterLeft.getAppliedOutput());
    }

    public void shoot(ShooterModes mode) {
        shooterLeft.set(mode.leftRPM);
        shooterRight.set(-mode.leftRPM);
    }

    
    
}
