package frc.robot.components;

import frc.robot.Constants;
import frc.robot.Robot;
import frc.team5431.titan.core.joysticks.CommandXboxController;

import frc.robot.Systems;

public class RobotContainer{
    private CommandXboxController driver;
    private CommandXboxController operator;
    private final static double SHOOT_SPEED = 1.0; // .6
    private final static double INTAKE_SPEED = 1.0; // .75 // .5

    public RobotContainer(){
        driver = new CommandXboxController(Constants.DRIVER_JOYSTICK_ID);
        driver.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
        
        operator = new CommandXboxController(Constants.OPERATOR_JOYSTICK_ID);
        operator.setDeadzone(Constants.DRIVER_JOYSTICK_DEADZONE);
    }

    public void periodic(final Robot robot){

        Systems system = new Systems();

        //better drivate arcade with the sticks
        system.getDrivebase().driveArcade(driver.getLeftY(), driver.getLeftX());

        //better shoot on b
        operator.b().whileTrue(robot.getShooter().runShooterCommand(SHOOT_SPEED)).onFalse(robot.getShooter().runShooterCommand(0));

        //better intake on a
        operator.a().whileTrue(robot.getIntake().runIntakeCommand(INTAKE_SPEED)).onFalse(robot.getIntake().runIntakeCommand(0));

        //better reverse intake on x
        operator.x().whileTrue(robot.getIntake().runIntakeCommand(-INTAKE_SPEED)).onFalse(robot.getIntake().runIntakeCommand(0));
        
    }
}