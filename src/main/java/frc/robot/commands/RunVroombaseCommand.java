package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Vroombase;

public class RunVroombaseCommand extends Command {
    public DoubleSupplier move;
    public DoubleSupplier turn;
    public Vroombase vroombase;

    public RunVroombaseCommand (Vroombase vroombase, DoubleSupplier move, DoubleSupplier turn) {
        this.vroombase = vroombase;
        this.move = move;
        this.turn = turn;
        addRequirements(vroombase);
    }

    @Override
    public void execute() {
        vroombase.move(move.getAsDouble(), turn.getAsDouble());
    }
    
    @Override
    public void end(boolean interrupted) {
        vroombase.move(0, 0);
    }
}
