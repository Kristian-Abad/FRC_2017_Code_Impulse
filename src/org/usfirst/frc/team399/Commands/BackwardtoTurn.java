package org.usfirst.frc.team399.Commands;

import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.Command;

public class BackwardtoTurn extends Command {

	double targetInInches;
	double targetAngle;
	double time;
	public BackwardtoTurn(double targetininches, double angletarget, double time){
		targetInInches = targetininches;
		targetAngle = angletarget;
		time = time;
	}
	@Override
	protected void initialize() {
		Supersystem.getInstance().reset(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		double pulse = Supersystem.getInstance().rightenc.getDistance();
		double angle = Supersystem.getInstance().ahrs.getAngle();
		Supersystem.getInstance().drive.easyBackwardTurn(pulse, angle, targetInInches, targetAngle);
		setTimeout(time);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Supersystem.getInstance().drive.tankDrive(0.0,0.0);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().drive.tankDrive(0.0,0.0);
		// TODO Auto-generated method stub
		
	}
}
