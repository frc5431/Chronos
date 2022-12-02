package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.components.*;


public class Robot extends TimedRobot {
    private static enum Mode{
        DISABLED, TELEOP
    }

    private Mode mode = Mode.DISABLED;

    private Systems system = new Systems();

    private Drivebase drivebase;
    private Intake intake;
    private Shooter shooter;

    private RobotContainer teleop;

    @Override
    public void robotInit(){
        teleop = new RobotContainer();

        drivebase = system.getDrivebase();
        intake = system.getIntake();
        shooter = system.getShooter();
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        mode = Mode.TELEOP;
    }

    @Override
    public void teleopPeriodic() {
        teleop.periodic(this);
    }

    @Override
    public void disabledInit(){
        mode = Mode.DISABLED;
    }

    public Mode getMode(){
        return mode;
    }

    public RobotContainer getTeleop(){
        return teleop;
    }
    
    public Drivebase getDrivebase(){
         return drivebase;
    }

    public Shooter getShooter(){
        return shooter;
    }

    public Intake getIntake(){
        return intake;
    }
}