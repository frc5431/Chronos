package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vroombase extends SubsystemBase {
    public SparkBase leftBack;
    public SparkBase rightBack;
    public SparkBase leftFront;
    public SparkBase rightFront;
    public SparkBaseConfig leftBackConfig;
    public SparkBaseConfig rightBackConfig;
    public SparkBaseConfig leftFrontConfig;
    public SparkBaseConfig rightFrontConfig;
    

    public Vroombase (SparkBase leftBack, SparkBase rightBack, SparkBase leftFront, SparkBase rightFront) {
        this.leftBack = leftBack;
        this.rightBack = rightBack;
        this.leftFront = leftFront;
        this.rightFront = rightFront;

        rightFrontConfig.idleMode(IdleMode.kCoast);
        leftFrontConfig.idleMode(IdleMode.kCoast);
        rightBackConfig.idleMode(IdleMode.kBrake);
        leftBackConfig.idleMode(IdleMode.kBrake);

        rightBack.configure(rightBackConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        rightFront.configure(rightFrontConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        leftBack.configure(leftBackConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
        leftFront.configure(leftFrontConfig, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
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
