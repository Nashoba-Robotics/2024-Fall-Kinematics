package frc.robot.subsystems.arm;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.geometry.Rotation2d;
import frc.robot.Constants.Arm;

public class ArmIOTalonFX implements ArmIO{
    TalonFX extendMotor;
    TalonFX armMotor;
    TalonFX armMotor2;
    CANcoder armEncoder;

    TalonFXConfiguration extendConfig;
    TalonFXConfiguration armConfig;

    public ArmIOTalonFX(){
        extendMotor = new TalonFX(Arm.EXTEND_PORT, Arm.CAN_BUS);
        armMotor = new TalonFX(Arm.ARM_PORT, Arm.CAN_BUS);
        armMotor2 = new TalonFX(Arm.ARM_PORT_2, Arm.CAN_BUS);

        armEncoder = new CANcoder(Arm.ENCODER_PORT, Arm.CAN_BUS);

        //For all uninitialized constants, create a constant for it in the constants file and use it here
        extendConfig = new TalonFXConfiguration();
        extendConfig.CurrentLimits.StatorCurrentLimit = 0;
        extendConfig.CurrentLimits.StatorCurrentLimitEnable = false ;
        extendConfig.CurrentLimits.SupplyCurrentLimit = 0;
        extendConfig.CurrentLimits.SupplyCurrentLimitEnable = false;

        extendConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        extendConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;   //TODO: Make sure this is correct
        extendConfig.Slot0 = Arm.EXTEND_PID; //I implemented this part for you because I'm nice. However, you still need to tune the PID values
        extendConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = false;
        extendConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold = 0;
        extendConfig.SoftwareLimitSwitch.ReverseSoftLimitEnable = false;
        extendConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold = 0;

        armConfig = new TalonFXConfiguration();
        armConfig.CurrentLimits.StatorCurrentLimit = 0;
        armConfig.CurrentLimits.StatorCurrentLimitEnable = false ;
        armConfig.CurrentLimits.SupplyCurrentLimit = 0;
        armConfig.CurrentLimits.SupplyCurrentLimitEnable = false;
        armConfig.MotorOutput.NeutralMode = NeutralModeValue.Brake;
        armConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;   //TODO: Make sure this is correct
        armConfig.Slot0 = Arm.ARM_PID; //I implemented this part for you because I'm nice. However, you still need to tune the PID values
        armConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = false;
        armConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold = 0;
        armConfig.SoftwareLimitSwitch.ReverseSoftLimitEnable = false;
        armConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold = 0;

        armConfig.Feedback.FeedbackSensorSource = FeedbackSensorSourceValue.SyncCANcoder;
        armConfig.Feedback.FeedbackRemoteSensorID = Arm.ENCODER_PORT;
        armConfig.Feedback.FeedbackRotorOffset = Arm.ENCODER_OFFSET;
        armConfig.Feedback.RotorToSensorRatio = Arm.ARM_GEAR_RATIO;
        armConfig.Feedback.SensorToMechanismRatio = Arm.ENCODER_TO_ARM_RATIO;

        //Sets the second arm motor to follow the first one.
        armMotor2.setControl(new Follower(Arm.ARM_PORT, true));
    }


    @Override
    public void updateInputs(ArmIOInputs input) {
        
    }

    @Override
    public void setAngle(Rotation2d angle) {
        
    }

    @Override
    public void setAngleVelocity(Rotation2d velocity) {
        
    }

    @Override
    public void setExtendRot(double rot) {
        
    }

    // TODO: Figure out thi function
    public double mToRotation(double m){
        return m;
    }

    @Override
    public void setExtendM(double m) {
        setExtendRot(mToRotation(m));
    }

    
}
