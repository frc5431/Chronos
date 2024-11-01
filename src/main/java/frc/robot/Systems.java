package frc.robot;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vroombase;

public class Systems {
    public static Systems instance;
    public Vroombase vroombase;
    public Shooter shooter;
    public Intake intake;

    public CANSparkBase intakeMotor;
    public CANSparkBase shooterLeft;
    public CANSparkBase shooterRight;
    public CANSparkBase vroomLeftB;
    public CANSparkBase vroomRightB;
    public CANSparkBase vroomLeftF;
    public CANSparkBase vroomRightF;
    
    public Systems () {

        intakeMotor = new CANSparkMax(Constants.IntakeConstants.id, MotorType.kBrushed);

        vroomLeftB = new CANSparkMax(Constants.DrivebaseConstants.leftBID, MotorType.kBrushless);
        vroomRightB = new CANSparkMax(Constants.DrivebaseConstants.rightBID, MotorType.kBrushless);
        vroomLeftF = new CANSparkMax(Constants.DrivebaseConstants.leftFID, MotorType.kBrushless);
        vroomRightF = new CANSparkMax(Constants.DrivebaseConstants.rightFID, MotorType.kBrushless);

        shooterLeft = new CANSparkMax(Constants.ShooterConstants.leftID, MotorType.kBrushed);
        shooterRight = new CANSparkMax(Constants.ShooterConstants.rightID, MotorType.kBrushed);

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