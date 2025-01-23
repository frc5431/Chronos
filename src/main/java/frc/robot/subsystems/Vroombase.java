package frc.robot.subsystems;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Vroombase extends SubsystemBase {
    SparkBase leftBack = new SparkMax(1, MotorType.kBrushless);
    SparkBase rightBack = new SparkMax(1, MotorType.kBrushless);
    SparkBase leftFront = new SparkMax(1, MotorType.kBrushless);
    SparkBase rightFront = new SparkMax(1, MotorType.kBrushless);
    SparkMaxConfig config = new SparkMaxConfig();
    

    public Vroombase (SparkBase leftBack, SparkBase rightBack, SparkBase leftFront, SparkBase rightFront) {
        this.leftBack = leftBack;
        this.rightBack = rightBack;
        this.leftFront = leftFront;
        this.rightFront = rightFront;

        leftBack.setInverted(true);

        config.idleMode(IdleMode.kCoast);
        config.idleMode(IdleMode.kCoast);
        config.idleMode(IdleMode.kBrake);
        config.idleMode(IdleMode.kBrake);


        rightBack.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        rightFront.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftBack.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        leftFront.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
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
