// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.SUBSYSTEM.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Sucker extends SubsystemBase {
  /** Creates a new Sucker. */
  public WPI_TalonSRX sucker = new WPI_TalonSRX(Sucker_ID);
  public Sucker() {}
  public void suck(double s_speed){
    sucker.set(s_speed);
  }
  public void pause() {
    sucker.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
