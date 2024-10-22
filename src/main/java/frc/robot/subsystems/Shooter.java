package frc.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.Constants.ShooterConstants.ShooterModes;

public class Shooter extends SubsystemBase {
    public ShooterModes modes;
    
    public CANSparkBase shooterLeft;
    public CANSparkBase shooterRight;
    public RelativeEncoder shooterEncoderLeft;
    public RelativeEncoder shooterEncoderRight;
    public SparkPIDController shooterControllerRight;
    public SparkPIDController shooterControllerLeft;

    private final double[] pid = new double[] { ShooterConstants.p, ShooterConstants.i, ShooterConstants.d };

    private double iZone = 0.1;

    public Shooter(CANSparkBase shooterLeft, CANSparkBase shooterRight) {
        this.shooterLeft = shooterLeft;
        this.shooterRight = shooterRight;
        shooterLeft.setIdleMode(IdleMode.kCoast);

        shooterControllerRight.setP(pid[0]);
        shooterControllerRight.setI(pid[1]);
        shooterControllerRight.setD(pid[2]);
        shooterControllerRight.setIZone(iZone);
        shooterControllerRight.setOutputRange(ShooterConstants.OutputRangeMin, ShooterConstants.OutputRangeMax);
        shooterControllerRight.setFeedbackDevice(shooterEncoderRight);
        
        shooterControllerLeft.setP(pid[0]);
        shooterControllerLeft.setI(pid[1]);
        shooterControllerLeft.setD(pid[2]);
        shooterControllerLeft.setIZone(iZone);
        shooterControllerLeft.setOutputRange(ShooterConstants.OutputRangeMin, ShooterConstants.OutputRangeMax);
        shooterControllerLeft.setFeedbackDevice(shooterEncoderLeft);

    }
    
    public void shoot(ShooterModes mode) {
       shooterControllerLeft.setReference(mode.leftRPM, ShooterConstants.shooterControl);
       shooterControllerRight.setReference(mode.rightRPM, ShooterConstants.shooterControl);
    }

    
    
}
