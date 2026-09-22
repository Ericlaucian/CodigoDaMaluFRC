package frc.robot.Command;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystem.ConvenioSubsystem;
import frc.robot.subsystem.DriveSubsystem;
import frc.robot.subsystem.ShooterSubsystem;

public class DriveCommand extends Command{

    private DriveSubsystem drive; 
    private CommandXboxController controle;


    public DriveCommand (DriveSubsystem drive, CommandXboxController controle) {
        this.drive = drive;
        this.controle = controle;

        addRequirements( drive);

        }

    @Override 
    public void initialize () {
    }
     
    @Override
    public void execute () {

        drive.manual_drive(controle.getLeftY(), controle.getRightY(),controle.getLeftTriggerAxis(),controle.getRightTriggerAxis());

    }

    @Override
    public void end (boolean interrupted) {
        drive.parar_drive();
    }
    

}
