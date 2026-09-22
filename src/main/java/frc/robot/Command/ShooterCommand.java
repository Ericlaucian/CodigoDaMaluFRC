package frc.robot.Command;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystem.ConvenioSubsystem;
import frc.robot.subsystem.ShooterSubsystem;

public class ShooterCommand extends Command {
    
    private ShooterSubsystem Shooter;
    private ConvenioSubsystem Convenio;

    public ShooterCommand (ShooterSubsystem Shooter , ConvenioSubsystem Convenio) {
        this.Shooter = Shooter;
        this.Convenio = Convenio;

        addRequirements(Shooter , Convenio);
    }

    @Override 
    public void initialize () {
    }
     
    @Override
    public void execute () {

        Convenio.out ();
        Shooter.atirar();

    }

    @Override
    public void end (boolean interrupted) {
        Shooter.stopshooter();
        Convenio.stopconvenio();
    }
    


}
