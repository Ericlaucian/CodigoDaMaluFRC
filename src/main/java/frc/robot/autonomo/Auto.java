package frc.robot.autonomo;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Command.IntakeCommand;
import frc.robot.Command.ShooterCommand;
import frc.robot.subsystem.ConvenioSubsystem;
import frc.robot.subsystem.ShooterSubsystem;

public class Auto extends SequentialCommandGroup {
    public Auto (ShooterSubsystem shooterSubsystem, ConvenioSubsystem convenioSubsystem) {
        addCommands(
            new IntakeCommand(convenioSubsystem, shooterSubsystem).withTimeout(1),
            new ShooterCommand(shooterSubsystem, convenioSubsystem).withTimeout(1)
        );
    }
    
}
