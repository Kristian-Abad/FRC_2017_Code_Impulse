package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.BackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.ForwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.GearPickupReset;
import org.usfirst.frc.team399.Commands.NewResetSensors;
import org.usfirst.frc.team399.Commands.OldBackwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.PegGear;
import org.usfirst.frc.team399.Commands.ResetSensors;
import org.usfirst.frc.team399.Commands.UpdatedForwardDistancedStraightDrive;
import org.usfirst.frc.team399.Commands.UpdatedPegGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team399.Systems.Supersystem;

public class DriveStraight2 extends CommandGroup{
	
	
	
	public DriveStraight2(){
//		double angle = Supersystem.getInstance().ahrs.getAngle(); 
//		double pulse = Supersystem.getInstance().rightenc.getDistance();
//		boolean btnone = Supersystem.getInstance().gmbut1.get();
//		boolean btntwo = Supersystem.getInstance().gmbut2.get();
//		Supersystem.getInstance().rightenc.setDistancePerPulse(1);
		this.addSequential(new GearPickupReset(0.01));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new OldBackwardDistancedStraightDrive(67, 2.5));
		this.addSequential(new NewResetSensors(0.01));
		this.addSequential(new UpdatedPegGear(1.0, true));
		this.addSequential(new NewResetSensors(0.01));
		
//		this.addSequential(new UpdatedForwardDistancedStraightDrive(36, 5.0));

	}
	
}
