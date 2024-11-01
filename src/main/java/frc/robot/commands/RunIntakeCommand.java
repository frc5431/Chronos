package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IntakeConstants.IntakeModes;
import frc.robot.subsystems.Intake;

public class RunIntakeCommand extends Command {
    public Intake intake;
    public IntakeModes mode;

    public RunIntakeCommand(Intake intake, IntakeModes mode) {
        this.intake = intake;
        this.mode = mode;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        intake.runIntake(mode);
    }
    
    @Override
    public void end(boolean interrupted) {
        intake.runIntake(IntakeModes.NONE);
    }
}
