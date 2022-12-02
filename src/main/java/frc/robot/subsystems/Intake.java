package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    WPI_TalonSRX intake;

    public Intake(WPI_TalonSRX intake) {
        this.intake = intake;
    }

    public void run(final double speed) {
        intake.set(speed);
    }

    public void setDirection(boolean direction) {
        intake.setInverted(direction);
    }
}
