package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Systems {
    WPI_TalonSRX RIGHT_SHOOTER, LEFT_SHOOTER, INTAKE, FRONT_LEFT, FRONT_RIGHT, BACK_LEFT, BACK_RIGHT;

    public Shooter shooter;
    public Intake intake;
    public Drivebase drivebase;

    public Systems() {
        RIGHT_SHOOTER = new WPI_TalonSRX(Constants.RIGHT_SHOOTER_ID);
        RIGHT_SHOOTER.setInverted(Constants.RIGHT_SHOOTER_INVERTED);
        RIGHT_SHOOTER.setNeutralMode(NeutralMode.Coast);
        LEFT_SHOOTER = new WPI_TalonSRX(Constants.LEFT_SHOOTER_ID);
        LEFT_SHOOTER.follow(RIGHT_SHOOTER);

        INTAKE = new WPI_TalonSRX(Constants.INTAKE_ID);
        INTAKE.setInverted(Constants.INTAKE_INVERTED);
        INTAKE.setNeutralMode(NeutralMode.Brake);

        FRONT_LEFT = new WPI_TalonSRX(Constants.FRONT_LEFT_ID);
        FRONT_LEFT.setInverted(Constants.FRONT_LEFT_INVERTED);
        FRONT_LEFT.setNeutralMode(NeutralMode.Coast);

        FRONT_RIGHT = new WPI_TalonSRX(Constants.FRONT_RIGHT_ID);
        FRONT_RIGHT.setInverted(Constants.FRONT_RIGHT_INVERTED);
        FRONT_RIGHT.setNeutralMode(NeutralMode.Coast);

        BACK_LEFT = new WPI_TalonSRX(Constants.BACK_RIGHT_ID);
        BACK_LEFT.follow(FRONT_LEFT);

        BACK_LEFT = new WPI_TalonSRX(Constants.BACK_LEFT_ID);
        BACK_LEFT.follow(FRONT_LEFT);

        shooter = new Shooter(RIGHT_SHOOTER);
        intake = new Intake(INTAKE);
        drivebase = new Drivebase(FRONT_LEFT, FRONT_RIGHT);
    }
}
