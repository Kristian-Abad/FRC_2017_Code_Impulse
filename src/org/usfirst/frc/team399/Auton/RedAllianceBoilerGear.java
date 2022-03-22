package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.BackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.BackwardtoTurn;
import org.usfirst.frc.team399.Commands.NewResetSensors;
import org.usfirst.frc.team399.Commands.Outtake;
import org.usfirst.frc.team399.Commands.PegGear;
import org.usfirst.frc.team399.Commands.TurntoAngle;
import org.usfirst.frc.team399.Commands.UpdatedForwardDistancedStraightDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class RedAllianceBoilerGear extends CommandGroup{

	public RedAllianceBoilerGear(){
		//working on, 11 seconds actual
		this.addSequential(new Outtake(-1,1.0));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new BackwardDistancedStraightDrive(36,1.0));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new TurntoAngle(76.27,2.0));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new BackwardDistancedStraightDrive(29,1.0));
		this.addSequential(new NewResetSensors(0.1));
		this.addSequential(new TurntoAngle(-90,2.0));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new BackwardDistancedStraightDrive(78,1.7));
//		this.addSequential(new PegGear(0.3));
//		this.addSequential(new NewResetSensors(0.01));
//		this.addSequential(new UpdatedForwardDistancedStraightDrive(36,2.0));
		
	
	}
}
