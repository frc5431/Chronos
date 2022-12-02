package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class IntakeCommand extends CommandBase {
    Intake intake;
    double speed;

    public IntakeCommand(Intake intake) {
        this(intake, Constants.INTAKE_SPEED);
    }
    public IntakeCommand(Intake intake, double speed) {
        this(intake, speed, false);
    }
    public IntakeCommand(Intake intake, double speed, boolean reverse) {
        this.intake = intake;
        this.speed = speed;
        intake.setDirection(reverse);

        addRequirements(intake);
    }

    @Override
    public void initialize() {
        super.initialize();
        intake.run(speed);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        intake.run(0);
    }
}
