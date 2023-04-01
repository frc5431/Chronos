package frc.robot.components.Commands;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;

public class RunShooterCommand {
    
    public Command runShooterCommand(WPI_TalonSRX requestedMotor, double speed) {
        return new StartEndCommand(() -> requestedMotor.set(speed), () -> requestedMotor.setNeutralMode(NeutralMode.Coast));
    }
    
}
