package frc.robot.components;

import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.team5431.titan.core.joysticks.CommandXboxController;

public class Teleop{
    private CommandXboxController driver;
    private CommandXboxController operatorController;


    public Teleop(){
        driver = new CommandXboxController(Constants.DRIVER_JOYSTICK_ID);
        driver.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
        
        operatorController = new CommandXboxController(Constants.OPERATOR_JOYSTICK_ID);
        operatorController.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
        
    }

    public void periodic(final Robot robot){

        var operator = operatorController.getHID();

        // robot.getDrivebase().drive(leftY, rightY);
        robot.getDrivebase().driveArcade(
                driver.getLeftY(), 
                driver.getLeftX()
        );

        operator.getBButton(new RunCommand(robot.getShooter().shooter(Constants.SHOOT_SPEED), null));
       

        if(operator.getBButton() || operator.getAButton()){
            robot.getIntake().runIntake(INTAKE_SPEED);
        } else if (operator.getXButton()) {
            robot.getIntake().runIntake(-INTAKE_SPEED);
        } else {
            robot.getIntake().runIntake(0);
        }
    }
}