package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.BackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.NewResetSensors;
import org.usfirst.frc.team399.Commands.Outtake;
import org.usfirst.frc.team399.Commands.TurntoAngle;
import org.usfirst.frc.team399.Commands.UpdatedForwardDistancedStraightDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class RedAllianceBoilerHopperBoiler extends CommandGroup{
	public RedAllianceBoilerHopperBoiler(){
		this.addSequential(new Outtake(-1,2.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new BackwardDistancedStraightDrive(90.672,1.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new TurntoAngle(-133.75,1.0));
		this.addSequential(new UpdatedForwardDistancedStraightDrive(82.349,1.0));
		this.addParallel(new WaitCommand(2.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new BackwardDistancedStraightDrive(24,0.5));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new TurntoAngle(-46.25,1.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new BackwardDistancedStraightDrive(38.424,1.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new TurntoAngle(90,1.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new UpdatedForwardDistancedStraightDrive(50.237,0.5));
		this.addSequential(new Outtake(-1,3.0));
	}
}