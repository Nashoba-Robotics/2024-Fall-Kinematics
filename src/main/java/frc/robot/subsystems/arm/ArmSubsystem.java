package frc.robot.subsystems.arm;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase{
    ArmIO armIO;
    ArmIOInputsAutoLogged inputs = new ArmIOInputsAutoLogged();

    public ArmSubsystem(){
        armIO = new ArmIOTalonFX();
    }

    @Override
    public void periodic() {
        armIO.updateInputs(inputs);
        Logger.processInputs("Arm", inputs);
    }

    /*
     * Maps inputs from the cartesian plane (meters) to polar coordinates
     *  - Note that (x, 0) is the floor, not the height of the pivot
     */
    double[] posToArmInputs(double x, double y){
        return new double[2];
    }

    /*
     * Maps inputs from polar coordinates to those in the cartesian plane
     *  - Note that (x, 0) (in the cartesian plane) is the floor, not the height of the pivot
     *  - This means that (STORED_LEN, 0) should return (0, ROBOT_HEIGHT + STORED_LEN)
     */
    double[] armToPos(double m, double angle){
        return new double[2];
    }
}
