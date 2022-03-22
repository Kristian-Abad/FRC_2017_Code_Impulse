package org.usfirst.frc.team399.Commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Systems.Drivetrain;



public class OldBackwardDistancedStraightDrive extends Command {
	private double Pulses;
	private double Angle;
	private double Distance;
	private double Timeout;
	Supersystem Bot = Supersystem.getInstance();
	
	public OldBackwardDistancedStraightDrive(double targetDistance, double timeout){
		Distance = targetDistance;
		Timeout = timeout;
		
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
		Supersystem.getInstance().drive.easyBackwardStraight(pulse, angle, Distance);
		Supersystem.getInstance().gp.autonRun(false);
		System.out.println(pulse + "Backward dist.");
		setTimeout(Timeout);
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
