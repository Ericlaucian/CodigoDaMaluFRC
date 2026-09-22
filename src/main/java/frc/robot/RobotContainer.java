// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Command.DriveCommand;
import frc.robot.Command.IntakeCommand;
import frc.robot.Command.ShooterCommand;
import frc.robot.subsystem.ConvenioSubsystem;
import frc.robot.subsystem.DriveSubsystem;
import frc.robot.subsystem.ShooterSubsystem;


public class RobotContainer {

  
      CommandXboxController controle = new CommandXboxController(0);
     private ShooterSubsystem shooterSubsystem = new ShooterSubsystem() ; 
     private ConvenioSubsystem convenioSubsystem = new ConvenioSubsystem(); 
     private DriveSubsystem driveSubsystem = new DriveSubsystem();
   

  public RobotContainer() {
    configureBindings();

  }
 
  private void configureBindings() {
  
    controle.a().whileTrue(new ShooterCommand ( shooterSubsystem, convenioSubsystem ));
    controle.b().whileTrue(new IntakeCommand(convenioSubsystem, shooterSubsystem));
    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, controle));
  }


  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
