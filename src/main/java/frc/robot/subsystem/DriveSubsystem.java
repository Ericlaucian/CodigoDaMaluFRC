package frc.robot.subsystem;

import java.lang.ModuleLayer.Controller;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    
    private SparkMax m_right_leader = new SparkMax(17, MotorType.kBrushless);
    private SparkMax m_right_follower = new SparkMax(23, MotorType.kBrushless);

    private SparkMax m_left_leader = new SparkMax(24, MotorType.kBrushless);
    private SparkMax m_left_follower = new SparkMax(16, MotorType.kBrushless);

    private DifferentialDrive drive;

    private SparkMaxConfig c_seguir_right = new SparkMaxConfig();
    private SparkMaxConfig c_seguir_left = new SparkMaxConfig();
    private SparkMaxConfig c_driveinverted = new SparkMaxConfig();
    private SparkMaxConfig c_leader = new SparkMaxConfig();

    double tolerancia = 0.06;


    public DriveSubsystem () {

        c_seguir_left.follow(m_left_leader);
        c_seguir_right.follow(m_right_leader);

        c_driveinverted.inverted(true);
        c_leader.inverted(false);


        m_left_follower.configure(c_seguir_left,

            ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters  );

        m_right_follower.configure(c_seguir_right, 
            ResetMode.kResetSafeParameters, 
            PersistMode.kPersistParameters  );

        m_left_leader.configure(c_driveinverted,
            ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters  );

        m_right_leader.configure(c_leader, 
            ResetMode.kResetSafeParameters,
            PersistMode.kPersistParameters  );


        drive = new DifferentialDrive(m_left_leader, m_right_leader);
    }

  public void manual_drive (double left_axis ,
    double right_axis ,
    double left_trigger ,
    double right_trigger) { 

        if ( right_trigger > tolerancia || left_trigger > tolerancia ) {
            drive.tankDrive(left_trigger, right_trigger);

        } else if (Math.abs(right_axis) > tolerancia || Math.abs(left_axis) > tolerancia) {
            drive.tankDrive(left_axis * 0.4, right_axis * 0.4);

        } else { 
            drive.tankDrive(0, 0);
        }
  }
  
    public void parar_drive() {
        drive.tankDrive(0, 0);
    }


}