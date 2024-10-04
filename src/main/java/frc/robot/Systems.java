package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.subsystems.Vroombase;

public class Systems {
    public static Systems instance;
    // public Manipulator manipulator;
    public Vroombase vroombase;

    // public Spark manipulatorLeft = new Spark(Constants.ManipulatorConstants.leftManipulatorID);
    // public Spark manipulatorRight = new Spark(Constants.ManipulatorConstants.rightManipulatorID);

    public Spark vroomLeft = new Spark(Constants.DrivebaseConstants.leftID);
    public Spark vroomRight = new Spark(Constants.DrivebaseConstants.rightID);
    
    public Systems () {
        // manipulator = new Manipulator(manipulatorLeft, manipulatorRight);
        vroombase = new Vroombase(vroomLeft, vroomRight);
        instance = this;
    }

    // public Manipulator getManipulator () {
    //     return manipulator;
    // }

    public Vroombase getVroombase () {
        return vroombase;
    }
}