package frc.robot.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkBase.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vroombase extends SubsystemBase {
    public CANSparkBase leftBack;
    public CANSparkBase rightBack;
    public CANSparkBase leftFront;
    public CANSparkBase rightFront;
    

    public Vroombase (CANSparkBase leftBack, CANSparkBase rightBack, CANSparkBase leftFront, CANSparkBase rightFront) {
        this.leftBack = leftBack;
        this.rightBack = rightBack;
        this.leftFront = leftFront;
        this.rightFront = rightFront;

        leftBack.setInverted(true);

        rightFront.setIdleMode(IdleMode.kCoast);
        leftFront.setIdleMode(IdleMode.kCoast);
        rightBack.setIdleMode(IdleMode.kBrake);
        leftBack.setIdleMode(IdleMode.kBrake);


        rightBack.burnFlash();
        rightFront.burnFlash();
        leftBack.burnFlash();
        leftFront.burnFlash();
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
