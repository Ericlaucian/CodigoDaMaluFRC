package frc.robot.subsystem;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private SparkMax m_shooter_right = new SparkMax(21, MotorType.kBrushless);
    private SparkMax m_shooter_left = new SparkMax(22, MotorType.kBrushless);
    
    private SparkMaxConfig c_shooter_left = new SparkMaxConfig();
    private SparkMaxConfig c_shooter_right = new SparkMaxConfig();
    
    
    public ShooterSubsystem () {
        c_shooter_left.inverted(true);
        c_shooter_right.inverted(false);

        m_shooter_left.configure(c_shooter_left,
         ResetMode.kResetSafeParameters,
         PersistMode.kPersistParameters);

        m_shooter_left.configure(c_shooter_left,
         ResetMode.kResetSafeParameters,
         PersistMode.kPersistParameters);
        

    }

    public void atirar () {
        m_shooter_left.setVoltage(6);
        m_shooter_right.setVoltage(6);
    };

    public void stopshooter () {
        m_shooter_left.setVoltage(0);
        m_shooter_right.setVoltage(0);
    }
}
