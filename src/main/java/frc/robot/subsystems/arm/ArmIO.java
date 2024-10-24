package frc.robot.subsystems.arm;

import edu.wpi.first.math.geometry.Rotation2d;

public interface ArmIO {
    public static class ArmIOInputs{
        public double extendRot = 0; //Rotations
        public double extendM = 0; //m
        public double extendVelRPS = 0; //Rot/s
        public double extendVelMS = 0; //M/s
        public double extendStator = 0; //A
        public double extendSupply = 0; //A
        public double extendVoltage = 0; //V

        public double armAngle = 0; //rad (Angle from the encoder)
        public double armAngleRotor = 0; //rad (Angle from the motor)
        public double armVel = 0; //rad/s
        public double armStator = 0; //A
        public double armSupply = 0; //A
        public double armVoltage = 0; //V
    }

    public default void updateInputs(ArmIOInputs input) {}
    public abstract void setAngle(Rotation2d angle);
    public abstract void setAngleVelocity(Rotation2d velocity);
    public abstract void setExtendRot(double rot);
    public abstract void setExtendM(double m);
}
