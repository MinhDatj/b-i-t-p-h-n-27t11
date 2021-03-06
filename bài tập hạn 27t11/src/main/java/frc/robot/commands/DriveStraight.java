// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveBase;

public class DriveStraight extends CommandBase {
  /** Creates a new DriveStright. */
  private DriveBase m_drivebase;
  private double v;
  public DriveStraight(DriveBase drivebase,double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    drivebase = m_drivebase;
    speed = v;
    addRequirements(m_drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_limitSwitch.get() == true){
      m_drivebase.drive(0,0);
      m_limitSwitch1.set(0);
    }
    else{
      m_drivebase.drive(v,v);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
