package frc.robot.Command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.ConvenioSubsystem;
import frc.robot.subsystem.ShooterSubsystem;

public class IntakeCommand extends Command {

    private ShooterSubsystem Shooter;
    private ConvenioSubsystem Convenio;

    public IntakeCommand (ConvenioSubsystem Convenio, ShooterSubsystem Shooter) {
        this.Convenio = Convenio;
        this.Shooter = Shooter; 

        addRequirements( Shooter, Convenio);
    }

    @Override 
    public void initialize () {
    }
     
    @Override
    public void execute () {
        Convenio.in ();
        Shooter.atirar();
    }

    @Override
    public void end (boolean interrupted) {
        Convenio.stopconvenio();
        Shooter.stopshooter();
    }

}
