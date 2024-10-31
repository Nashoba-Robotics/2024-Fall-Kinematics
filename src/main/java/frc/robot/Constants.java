// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.signals.GravityTypeValue;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  //TODO: Find ALL of these constants
  public static class Arm{
    public static final int EXTEND_PORT = 0;
    public static final int ARM_PORT = 0;
    public static final int ARM_PORT_2 = 0;
    public static final int ENCODER_PORT = 0;
    public static final String CAN_BUS = "canbus";

    public static final Slot0Configs EXTEND_PID = new Slot0Configs()
      .withKS(0)  //TODO: Fill these out
      .withKV(0)
      .withKP(0)
      .withKI(0)
      .withKD(0);

    public static final Slot0Configs ARM_PID = new Slot0Configs()
      .withGravityType(GravityTypeValue.Arm_Cosine)
      .withKS(0)  //TODO: Fill these out
      .withKV(0)    
      .withKG(0)
      .withKP(0)
      .withKI(0)
      .withKD(0);

    public static final double ARM_GEAR_RATIO = 4*4*4*72/22.; //How many times must the motor rotate to turn the encoder once?
    public static final double ENCODER_OFFSET = 0; //Units in rotations
    public static final double ENCODER_TO_ARM_RATIO = 1; //When the encoder rotates once, the arm rotates once
  }
}
