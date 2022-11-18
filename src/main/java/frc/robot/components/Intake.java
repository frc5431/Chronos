package frc.robot.components;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;

public class Intake{
    private final WPI_TalonSRX intake;

    public Intake(){
        intake = new WPI_TalonSRX(Constants.INTAKE_ID);
        intake.setInverted(Constants.INTAKE_INVERTED);
        intake.setNeutralMode(NeutralMode.Brake);
    }

    public void runIntake(final double speed) {
        intake.set(speed);
    }
}