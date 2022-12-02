package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class ShootCommand extends CommandBase {
    Shooter shooter;
    double speed;

    public ShootCommand(Shooter shooter, double speed) {
        this.shooter = shooter;
        this.speed = speed;

        addRequirements(shooter);
    }
    public ShootCommand(Shooter shooter) {
        this(shooter, Constants.INTAKE_SPEED);
    }

    @Override
    public void initialize() {
        super.initialize();
        shooter.run(speed);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        shooter.run(0);
    }
}
