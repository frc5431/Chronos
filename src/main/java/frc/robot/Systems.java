package frc.robot;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vroombase;

public class Systems {
    public static Systems instance;
    public Vroombase vroombase;
    public Shooter shooter;
    public Intake intake;

    public SparkBase intakeMotor;
    public SparkBase shooterLeft;
    public SparkBase shooterRight;
    public SparkBase vroomLeftB;
    public SparkBase vroomRightB;
    public SparkBase vroomLeftF;
    public SparkBase vroomRightF;
    
    public Systems () {

        intakeMotor = new SparkMax(Constants.IntakeConstants.id, MotorType.kBrushed);

        vroomLeftB = new SparkMax(Constants.DrivebaseConstants.leftBID, MotorType.kBrushless);
        vroomRightB = new SparkMax(Constants.DrivebaseConstants.rightBID, MotorType.kBrushless);
        vroomLeftF = new SparkMax(Constants.DrivebaseConstants.leftFID, MotorType.kBrushless);
        vroomRightF = new SparkMax(Constants.DrivebaseConstants.rightFID, MotorType.kBrushless);

        shooterLeft = new SparkMax(Constants.ShooterConstants.leftID, MotorType.kBrushed);
        shooterRight = new SparkMax(Constants.ShooterConstants.rightID, MotorType.kBrushed);

        vroombase = new Vroombase(vroomLeftB, vroomRightB, vroomLeftF, vroomRightF);
        shooter = new Shooter(shooterLeft, shooterRight);
        intake = new Intake(intakeMotor);

        instance = this;
    }

    public Vroombase getVroombase() {
        return vroombase;
    }

     public Shooter getShooter() {
        return shooter;
    }

     public Intake getIntake() {
        return intake;
    }



}