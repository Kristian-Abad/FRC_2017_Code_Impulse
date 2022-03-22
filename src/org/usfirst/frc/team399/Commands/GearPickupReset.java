package org.usfirst.frc.team399.Commands;

import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.Command;

public class GearPickupReset extends Command {
	double timeout;
	
	public GearPickupReset(double time){
		timeout = time;
	}
	@Override
	protected void initialize() {
		Supersystem.getInstance().gpencoder.reset();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		//currently gets stuck on this Command
		Supersystem.getInstance().gpencoder.reset();
		setTimeout(timeout);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void end() {
		Supersystem.getInstance().gpencoder.reset();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().gpencoder.reset();
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

}
