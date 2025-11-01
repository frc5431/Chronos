package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants.ShooterModes;

public class Shooter extends SubsystemBase {
    public ShooterModes modes;

    public SparkMax shooterLeft;
    public SparkMax shooterRight;
    public SparkMaxConfig shooterLeftConfig = new SparkMaxConfig();
    public SparkMaxConfig shooterRightConfig = new SparkMaxConfig();

    public Shooter(SparkMax shooterLeft, SparkMax shooterRight) {
        this.shooterLeft = shooterLeft;
        this.shooterRight = shooterRight;
        shooterLeftConfig.idleMode(IdleMode.kCoast);
        shooterRightConfig.idleMode(IdleMode.kCoast);
        shooterLeft.configure(shooterLeftConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        shooterRight.configure(shooterRightConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);

    }

    public void periodic() {
        SmartDashboard.putNumber("Shooter", shooterLeft.getAppliedOutput());
    }

    public void shoot(ShooterModes mode) {
        // shooterLeft.set(mode.leftRPM);
        // shooterRight.set(-mode.leftRPM);
        shooterLeft.set(.8);
        shooterLeft.set(-.8);
    }

}
