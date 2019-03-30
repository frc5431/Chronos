package frc.robot.components;

import frc.robot.components.Drivebase;
import frc.robot.components.Intake;
import frc.robot.components.Shooter;
import frc.robot.Titan;
import frc.robot.Constants;
import frc.robot.Robot;

public class Teleop{
    private Titan.Xbox driver;
    private final static double SHOOT_SPEED = .6; 

    public Teleop(){
        driver = new Titan.Xbox(Constants.DRIVER_JOYSTICK_ID);
        driver.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
        
    }

    public void periodic(final Robot robot){

        final double leftY = driver.getRawAxis(Titan.Xbox.Axis.LEFT_Y);
        final double rightY = driver.getRawAxis(Titan.Xbox.Axis.RIGHT_Y);

        robot.getDrivebase().drive(leftY, rightY);

        if(driver.getRawButton(Titan.Xbox.Button.A)){
            robot.getShooter().shooter(SHOOT_SPEED);
        } else {
            robot.getShooter().shooter(0);
        }

        if(driver.getRawButton(Titan.Xbox.Button.A)){
            robot.getIntake().runIntake(.5);
        } else {
            robot.getIntake().runIntake(0);
        }
        
    }

    public Titan.Xbox getDriver(){
      return driver;
    }

}