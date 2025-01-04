package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vroombase extends SubsystemBase {
    public SparkMax leftBack;
    public SparkMax rightBack;
    public SparkMax leftFront;
    public SparkMax rightFront;
    
    public SparkMaxConfig leftBackConfig;
    public SparkMaxConfig rightBackConfig;
    public SparkMaxConfig leftFrontConfig;
    public SparkMaxConfig rightFrontConfig;

    public Vroombase (SparkMax leftBack, SparkMax rightBack, SparkMax leftFront, SparkMax rightFront) {
        this.leftBack = leftBack;
        this.rightBack = rightBack;
        this.leftFront = leftFront;
        this.rightFront = rightFront;

        
        leftBackConfig.inverted(true);
        
        leftBackConfig.idleMode(IdleMode.kBrake);
        rightBackConfig.idleMode(IdleMode.kBrake);
        leftFrontConfig.idleMode(IdleMode.kCoast);
        rightFrontConfig.idleMode(IdleMode.kCoast);

        leftBack.configure(leftBackConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFront.configure(rightFrontConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftBack.configure(leftBackConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftFront.configure(leftFrontConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }



    public void leftSide(double speed) {
        leftBack.set(speed);
        //leftFront.set(speed);
    }

    public void rightSide(double speed) {
        rightBack.set(speed);
        //rightFront.set(speed);
    }
    
    public void periodic(){
        SmartDashboard.putNumber("rightback", rightBack.getAppliedOutput());
        SmartDashboard.putNumber("rightfront", rightFront.getAppliedOutput());
        SmartDashboard.putNumber("leftback", leftBack.getAppliedOutput());
        SmartDashboard.putNumber("leftfront", leftFront.getAppliedOutput());
    }

    public void move (double move, double turn) {
    
        if(move > 0.15 || move < -0.15){
           
            if(turn > 0.15 || turn < -0.15) {
                leftSide(0.5 * (move + turn));
                rightSide(0.5 * (move - turn));  
            } else {
                leftSide(0.5 * (move));
                rightSide(0.5 * (move));  
            }
         
        } else {
            leftSide(0);
            rightSide(0);   
        }

    } 
    

}
