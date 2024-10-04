package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Vroombase extends SubsystemBase {
    public Spark left;
    public Spark right;

    public Vroombase (Spark left, Spark right) {
        this.left = left;
        this.right = right;
    }
    
    public void move (double move, double turn) {
        double maximum = Math.max(Math.abs(move),Math.abs(turn));
        double total = move + turn;
        double difference = move - turn;
        
        if (move >= 0){
            if (turn >= 0) {
                left.set(maximum);
                right.set(difference);
            }
            else {
                left.set(total);
                left.set(maximum);
            }
        }
        else {
            if (turn >= 0) {
                left.set(total);
                right.set(-maximum);
            }
            else {
                left.set(-maximum);
                left.set(difference);
            }
        }
    } 
    

}
