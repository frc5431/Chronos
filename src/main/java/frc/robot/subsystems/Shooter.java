package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    WPI_TalonSRX shooter;

    public Shooter(WPI_TalonSRX shooter) {
        this.shooter = shooter;
    }

    public void run(final double speed) {
        shooter.set(speed);
    }
}
