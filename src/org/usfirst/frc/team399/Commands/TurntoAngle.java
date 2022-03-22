package org.usfirst.frc.team399.Commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Systems.Drivetrain;

public class TurntoAngle extends Command {
	private double targetAngle;

	private double timeout;
	public TurntoAngle(double targetAngle, double timeout){
		this.targetAngle = targetAngle;

		this.timeout = timeout;
	}
	
	@Override
	protected void initialize() {
//		Supersystem.getInstance().drive.turnAngle(bothpow, targetAngle, angle, negvalue);
		Supersystem.getInstance().reset(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		double angle = Supersystem.getInstance().ahrs.getAngle();
//		Supersystem.getInstance().gm.runGearManipulator(false, false, btn1, btn2);
//		Supersystem.getInstance().gp.autonRun(false);
		Supersystem.getInstance().drive.PIDTurn(Supersystem.getInstance().ahrs.getAngle(), targetAngle);
		setTimeout(timeout);
		// TODO Auto-generated method stub
		
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

	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

}
