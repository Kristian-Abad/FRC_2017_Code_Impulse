package org.usfirst.frc.team399.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team399.Commands.TurntoAngle;
import org.usfirst.frc.team399.Commands.NewResetSensors;
import org.usfirst.frc.team399.Commands.Outtake;
import org.usfirst.frc.team399.Commands.BackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.UpdatedForwardDistancedStraightDrive;

public class RedAllianceHopperAuton extends CommandGroup {
	
	public RedAllianceHopperAuton(){
		
		this.addSequential(new BackwardDistancedStraightDrive(75.751,0.5));
		this.addSequential(new TurntoAngle(-90,0.5));
		this.addSequential(new BackwardDistancedStraightDrive(84.369,0.5));
		this.addSequential(new NewResetSensors(0.5));
		this.addSequential(new BackwardDistancedStraightDrive(13.25,0.5));
		this.addSequential(new TurntoAngle(-136.25,0.5));
		this.addSequential(new NewResetSensors(0.5));
		this.addSequential(new UpdatedForwardDistancedStraightDrive(44.028,0.5));
		this.addSequential(new NewResetSensors(0.5));
		this.addSequential(new TurntoAngle(-90,0.5));
		this.addSequential(new NewResetSensors(0.5));
		this.addSequential(new UpdatedForwardDistancedStraightDrive(43.038,0.5));
		this.addSequential(new Outtake(-1,3.0));
		
		
//		this.addSequential(new BackwardDistancedStraightDrive(60,0.5));
//		this.addSequential(new TurntoAngle(46.25,0.5));
//		this.addSequential(new BackwardDistancedStraightDrive(103.708,2.0));
//		this.addSequential(new TurntoAngle(54.10,0.5));
//		this.addSequential(new UpdatedForwardDistancedStraightDrive(34.473,0.5));
//		this.addSequential(new BackwardDistancedStraightDrive(34.473,1.0));
//		this.addSequential(new TurntoAngle(54.1,1.0));
//		this.addSequential(new UpdatedForwardDistancedStraightDrive(59.247,1.0));
//		this.addSequential(new TurntoAngle(-90,1.0));
//		this.addSequential(new UpdatedForwardDistancedStraightDrive(60.731,1.0));
//		this.addSequential(new Outtake(-1,3.0));
		
		
	}
	
}
