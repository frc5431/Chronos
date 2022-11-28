package frc.robot.components;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.team5431.titan.core.joysticks.CommandXboxController;

public class Teleop{
    private CommandXboxController driver;
    private CommandXboxController operator;
    private final static double SHOOT_SPEED = 1.0; // .6
    private final static double INTAKE_SPEED = 1.0; // .75 // .5

    public Teleop(){
        driver = new CommandXboxController(Constants.DRIVER_JOYSTICK_ID);
        driver.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
        
        operator = new CommandXboxController(Constants.OPERATOR_JOYSTICK_ID);
        operator.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
    }

    public void periodic(final Robot robot){

        // robot.getDrivebase().drive(leftY, rightY);
        robot.getDrivebase().driveArcade(
                driver.getLeftY(), 
                driver.getLeftX()
        );

        if(operator.getHID().getBButton()){
            robot.getShooter().shooter(SHOOT_SPEED);
        } else {
            robot.getShooter().shooter(0);
        }

        if(operator.getHID().getBButton() || operator.getHID().getAButton()){
            robot.getIntake().runIntake(INTAKE_SPEED);
        } else if (operator.getHID().getXButton()) {
            robot.getIntake().runIntake(-INTAKE_SPEED);
        } else {
            robot.getIntake().runIntake(0);
        }   
    }
}