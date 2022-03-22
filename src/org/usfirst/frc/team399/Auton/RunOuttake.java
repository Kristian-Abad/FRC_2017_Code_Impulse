package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.BackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.Outtake;
import org.usfirst.frc.team399.Commands.PegGear;
import org.usfirst.frc.team399.Commands.TurntoAngle;
import org.usfirst.frc.team399.Commands.NewResetSensors;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RunOuttake extends CommandGroup{
	public RunOuttake(){
		this.addSequential(new Outtake(-1,10.0));
//		this.addSequential(new BackwardDistancedStraightDrive(11.252, 0.5));
//		this.addSequential(new NewResetSensors(0.2));
//		this.addSequential(new TurntoAngle(76.25,0.5));
//		this.addSequential(new BackwardDistancedStraightDrive(40.307, 0.5));
//		this.addSequential(new NewResetSensors(0.2));
//		this.addSequential(new TurntoAngle(-90,0.5));
//		this.addSequential(new BackwardDistancedStraightDrive(106.529, 0.5));
//		this.addSequential(new PegGear(0.5));
		
		
	}

}
