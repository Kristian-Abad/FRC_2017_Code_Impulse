package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.BackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.NewResetSensors;
import org.usfirst.frc.team399.Commands.TurntoAngle;
import org.usfirst.frc.team399.Commands.UpdatedForwardDistancedStraightDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BlueAllianceAwayFromBoilerOperationRichard extends CommandGroup {
	public BlueAllianceAwayFromBoilerOperationRichard(){
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new BackwardDistancedStraightDrive(190.073,3.0));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new TurntoAngle(90,0.5));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new BackwardDistancedStraightDrive(41,1.0));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new UpdatedForwardDistancedStraightDrive(36,1.0));
		this.addSequential(new TurntoAngle(-90,0.5));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new BackwardDistancedStraightDrive(238.126,3.0));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new TurntoAngle(90,0.5));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new BackwardDistancedStraightDrive(41,0.9));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new UpdatedForwardDistancedStraightDrive(36,1.0));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new TurntoAngle(-24,0.5));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new UpdatedForwardDistancedStraightDrive(300,3.0));
		
	}
}
