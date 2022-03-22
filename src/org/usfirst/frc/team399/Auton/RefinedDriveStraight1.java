package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.BackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.BackwardtoTurn;
import org.usfirst.frc.team399.Commands.GearPickupReset;
import org.usfirst.frc.team399.Commands.NewResetSensors;
import org.usfirst.frc.team399.Commands.PegGear;
import org.usfirst.frc.team399.Commands.TurntoAngle;
import org.usfirst.frc.team399.Commands.UpdatedForwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.UpdatedPegGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RefinedDriveStraight1 extends CommandGroup{
	public RefinedDriveStraight1(){
		this.addSequential(new GearPickupReset(0.01));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new BackwardDistancedStraightDrive(69.635,3.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new TurntoAngle(60,2.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new BackwardDistancedStraightDrive(68.263,1.0));
		this.addSequential(new UpdatedPegGear(2.0, true));
//		this.addSequential(new NewResetSensors(0.1));
//		this.addSequential(new UpdatedForwardDistancedStraightDrive(36,2.0));
		
	}

}
