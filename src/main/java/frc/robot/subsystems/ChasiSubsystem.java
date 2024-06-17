// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ChasiSubsystem extends SubsystemBase {
  
  WPI_TalonFX FR;
  WPI_TalonFX FL;
  WPI_TalonFX RL;
  WPI_TalonFX RR;
  
  public ChasiSubsystem() {
    FR = new WPI_TalonFX(1);
    FL = new WPI_TalonFX(2);
    RL = new WPI_TalonFX(21);
    RR = new WPI_TalonFX(11);

    FL.setInverted(true);
    RL.setInverted(true);
  }
  
  public void drive(double speedL, double speedR){
    if(!(Math.abs(speedL) < 0.1 || Math.abs(speedR) < 0.1)){
      FR.set(speedR);
      FL.set(speedL);
      RL.set(speedL);
      RR.set(speedR);
    }
  }

  public void stop(){
    FR.stopMotor();
    FL.stopMotor();
    RL.stopMotor();
    RR.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
