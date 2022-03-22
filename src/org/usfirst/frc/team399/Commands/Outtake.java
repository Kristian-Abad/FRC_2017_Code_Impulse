package org.usfirst.frc.team399.Commands;

import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.Command;

public class Outtake extends Command {
	private double pow;

	private double timeout;
	public Outtake(double value, double timeout){
		this.pow = value;
		this.timeout = timeout;
	}
	
	@Override
	protected void initialize() {
		Supersystem.getInstance().reset(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Supersystem.getInstance().innouttake.runInNOuttake(pow);
		setTimeout(timeout);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void end() {
		Supersystem.getInstance().innouttake.runInNOuttake(0.0);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().innouttake.runInNOuttake(0.0);
		// TODO Auto-generated method stub
		
	}

	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

}

