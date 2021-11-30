// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.SUBSYSTEM.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotContainer;
import static frc.robot.Constants.JOYSTICK.*;
import com.ctre.phoenix.motorcontrol.NeutralMode;


public class DriveBase extends SubsystemBase {
  /** Creates a new DriveBase. */
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(RIGHTMOTOR1_ID);
  public WPI_TalonSRX rightFollow = new WPI_TalonSRX(RIGHTMOTOR2_ID);
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(LEFTMOTOR1_ID);
  public WPI_TalonSRX leftFollow = new WPI_TalonSRX(LEFTMOTOR1_ID);
  public DriveBase() {
    rightFollow.follow(rightMaster);
    leftFollow.follow(leftMaster);
    leftMaster.setInverted(true);

    rightMaster.setNeutralMode(NeutralMode.Brake);
    rightFollow.setNeutralMode(NeutralMode.Brake);
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftFollow.setNeutralMode(NeutralMode.Brake);
  }

  public void drive(double leftDrive, double rightDrive){
    rightMaster.set(rightDrive);
    leftMaster.set(leftDrive);
  }

  public void stop() {
    rightMaster.set(0);
    leftMaster.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    double boost = RobotContainer.m_stick.getRawButton(X)? 0.8 : 0.4;
    drive(RobotContainer.m_stick.getRawAxis(L1)*boost,RobotContainer.m_stick.getRawAxis(L2)*boost);
  }
}
