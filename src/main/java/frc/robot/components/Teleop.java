package frc.robot.components;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.team5431.titan.core.joysticks.Xbox;

public class Teleop{
    private Xbox driver;
    private Xbox operator;
    private final static double SHOOT_SPEED = 1.0; // .6
    private final static double INTAKE_SPEED = 1.0; // .75 // .5

    public Teleop(){
        driver = new Xbox(Constants.DRIVER_JOYSTICK_ID);
        driver.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
        
        operator = new Xbox(Constants.OPERATOR_JOYSTICK_ID);
        operator.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
    }

    public void periodic(final Robot robot){

        // robot.getDrivebase().drive(leftY, rightY);
        robot.getDrivebase().driveArcade(
                driver.getRawAxis(Xbox.Axis.LEFT_Y), 
                driver.getRawAxis(Xbox.Axis.LEFT_X)
        );

        if(operator.getRawButton(Xbox.Button.B)){
            robot.getShooter().shooter(SHOOT_SPEED);
        } else {
            robot.getShooter().shooter(0);
        }

        if(operator.getRawButton(Xbox.Button.B) || operator.getRawButton(Xbox.Button.A)){
            robot.getIntake().runIntake(INTAKE_SPEED);
        } else if (operator.getRawButton(Xbox.Button.X)) {
            robot.getIntake().runIntake(-INTAKE_SPEED);
        } else {
            robot.getIntake().runIntake(0);
        }
        
    }

    public Xbox getDriver(){
      return driver;
    }

}