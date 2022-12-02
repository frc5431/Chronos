package frc.robot.components;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Systems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase{

    private WPI_TalonSRX intake;

    public static final double DEFAULT_SPEED = 1.0;
    public static final boolean REVERSE = false;
    public static final NeutralMode NEUTRALMODE = NeutralMode.Coast;

    public Intake(WPI_TalonSRX intake_new){

        intake = intake_new;

        intake = new WPI_TalonSRX(Constants.INTAKE_ID);
        intake.setInverted(REVERSE);
        intake.setNeutralMode(NEUTRALMODE);
    }

    public void runIntake(final double speed) {
        intake.set(speed);
    }

    public Command runIntakeCommand(boolean reverse){
        return runIntakeCommand(reverse ? -DEFAULT_SPEED : DEFAULT_SPEED);
    }

    public Command runIntakeCommand(double speed){
        return new StartEndCommand(() -> this.runIntake(speed), () -> this.runIntake(0), this);
    }

}