// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.SUBSYSTEM.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  public WPI_TalonSRX shooter = new WPI_TalonSRX(Shooter_ID);
  public Shooter(){}
  public void shoot(double S_speed){
    shooter.set(S_speed);
  }
  public void hold_fire(){
    shooter.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
