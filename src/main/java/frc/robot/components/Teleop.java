package frc.robot.components;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.team5431.titan.core.joysticks.Xbox;

public class Teleop{
    private Xbox driver;
    private final static double SHOOT_SPEED = 1.0; // .6
    private final static double INTAKE_SPEED = 1.0; // .75 // .5

    public Teleop(){
        driver = new Xbox(Constants.DRIVER_JOYSTICK_ID);
        driver.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
        
    }

    public void periodic(final Robot robot){

        // robot.getDrivebase().drive(leftY, rightY);
        robot.getDrivebase().driveArcade(
                driver.getRawAxis(Xbox.Axis.LEFT_Y), 
                driver.getRawAxis(Xbox.Axis.LEFT_X)
        );

        if(driver.getRawButton(Xbox.Button.B)){
            robot.getShooter().shooter(SHOOT_SPEED);
        } else {
            robot.getShooter().shooter(0);
        }

        if(driver.getRawButton(Xbox.Button.B) || driver.getRawButton(Xbox.Button.A)){
            robot.getIntake().runIntake(INTAKE_SPEED);
        } else if (driver.getRawButton(Xbox.Button.Y)) {
            robot.getIntake().runIntake(-INTAKE_SPEED);
        } else {
            robot.getIntake().runIntake(0);
        }
        
    }

    public Xbox getDriver(){
      return driver;
    }

}