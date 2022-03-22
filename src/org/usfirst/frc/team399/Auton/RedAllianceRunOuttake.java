package org.usfirst.frc.team399.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team399.Commands.BackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.NewResetSensors;
import org.usfirst.frc.team399.Commands.Outtake;
import org.usfirst.frc.team399.Commands.TurntoAngle;

public class RedAllianceRunOuttake extends CommandGroup {
	public RedAllianceRunOuttake(){
		this.addSequential(new Outtake(-1,7.0));
		this.addSequential(new BackwardDistancedStraightDrive(36, 1.0));
		this.addSequential(new NewResetSensors(0.5));
		this.addSequential(new TurntoAngle(46.26,1.0));
		this.addSequential(new NewResetSensors(0.5));
		this.addSequential(new BackwardDistancedStraightDrive(80, 2.5));
		
		
		
	}
}
