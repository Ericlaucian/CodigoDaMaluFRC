package frc.robot.subsystem;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConvenioSubsystem extends SubsystemBase{
    private SparkMax m_convenio = new SparkMax(5, MotorType.kBrushed);

    public void in () {
        m_convenio.setVoltage(5);
    }

    public void out () {
        m_convenio.setVoltage(-5);
    }

    public void stopconvenio () {
        m_convenio.setVoltage(0);
    }

}
