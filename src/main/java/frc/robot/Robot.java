package frc.robot;

import java.sql.Time;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.components.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Robot extends TimedRobot {
  private static enum Mode{
    DISABLED, TELEOP
  }

  private Mode mode = Mode.DISABLED;

  private Drivebase drivebase;
  private Intake intake;
  private Shooter shooter;

  private Teleop teleop;

  @Override
  public void robotInit(){
    teleop = new Teleop();

    drivebase = new Drivebase();
    intake = new Intake();
    shooter = new Shooter();
  }
  
  @Override
  public void robotPeriodic() {
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

  public Teleop getTeleop(){
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