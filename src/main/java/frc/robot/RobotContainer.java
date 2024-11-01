// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.IntakeConstants.IntakeModes;
import frc.robot.Constants.ShooterConstants.ShooterModes;
import frc.robot.commands.RunIntakeCommand;
import frc.robot.commands.RunShooterCommand;
import frc.robot.commands.RunVroombaseCommand;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vroombase;
import frc.team5431.titan.core.joysticks.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private final Systems systems = new Systems();
  public final Vroombase vroombase = systems.getVroombase();
  public final Intake intake = systems.getIntake();
  public final Shooter shooter = systems.getShooter();
  public static final CommandXboxController driver = new CommandXboxController(0);

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {

    // driver.setDeadzone(0.3);
  
    //driver.setDeadzone(0.15);


    vroombase.setDefaultCommand(
      new RunVroombaseCommand(vroombase,
        () -> driver.getLeftY(), () -> -driver.getLeftX())
    );

    driver.a().whileTrue(new RunIntakeCommand(intake, IntakeModes.INTAKE));
    driver.b().whileTrue(new RunIntakeCommand(intake, IntakeModes.OUTAKE));
    driver.rightTrigger().whileTrue(new RunShooterCommand(shooter, ShooterModes.SHOOT));
    driver.leftTrigger().whileTrue(new RunShooterCommand(shooter, ShooterModes.REVERSE));


  }

  
}
