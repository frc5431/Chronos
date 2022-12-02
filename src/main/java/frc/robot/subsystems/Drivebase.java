package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivebase extends SubsystemBase {
    private final WPI_TalonSRX left, right;

    public Drivebase(WPI_TalonSRX left, WPI_TalonSRX right){
        this.left = left;
        this.right = right;
    }

    // This is taken directly from legacy code...

    public void driveLeft(double val){
        left.set(val);
    }

    public void driveRight(double val){
        right.set(val);
    }

    public void drive(double left, double right){
        driveLeft(left);
        driveRight(right);
    }

    // Based on arcade drive pseudocode pdf found on CD
    public void driveArcade(final double forward, final double turn) {
        double max = Math.abs(forward);
        if (Math.abs(turn) > max)
            max = Math.abs(turn);

        double sum = forward + turn;
        double dif = forward - turn;

        if (forward > 0) {
            if (turn >= 0) {
                driveLeft(max);
                driveRight(dif);
            } else {
                driveLeft(sum);
                driveRight(max);
            }
        } else {
            if (turn >= 0) {
                driveLeft(sum);
                driveRight(-max);
            } else {
                driveLeft(-max);
                driveRight(dif);
            }
        }
    }
}
