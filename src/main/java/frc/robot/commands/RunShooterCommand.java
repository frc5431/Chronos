package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.ShooterConstants.ShooterModes;
import frc.robot.subsystems.Shooter;

public class RunShooterCommand extends Command {
    public Shooter shooter;
    public ShooterModes mode;

    public RunShooterCommand (Shooter shooter, ShooterModes mode) {
        this.shooter = shooter;
        this.mode = mode;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        shooter.shoot(mode);
    }
    
    @Override
    public void end(boolean interrupted) {
        shooter.shoot(ShooterModes.NONE);
    }
}
