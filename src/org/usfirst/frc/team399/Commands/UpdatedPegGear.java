package org.usfirst.frc.team399.Commands;

import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.Command;

public class UpdatedPegGear extends Command{

	boolean btn1;
	boolean btn2;
	boolean boole;
	double timeout;
	
	public UpdatedPegGear(double timeout, boolean bool){
		this.timeout = timeout;
		boole = bool;
	}
	@Override
	protected void initialize() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Supersystem.getInstance().gp.autonRun(boole);
		setTimeout(timeout);
		System.out.println("On Updated Peg Gear");
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		Supersystem.getInstance().gp.cutPivot();
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Supersystem.getInstance().gp.cutPivot();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().gp.cutPivot();
		// TODO Auto-generated method stub
		
	}

}
