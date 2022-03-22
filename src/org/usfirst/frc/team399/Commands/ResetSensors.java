package org.usfirst.frc.team399.Commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import com.kauailabs.navx.frc.AHRS;

import org.usfirst.frc.team399.Systems.Supersystem;

public class ResetSensors extends Command{
	private double timeout;
	
	public ResetSensors(double time){
		this.timeout = time;
	}
	
	@Override
	protected void initialize() {
		Supersystem.getInstance().reset(true);
		setTimeout(timeout);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Supersystem.getInstance().rightenc.reset();
		Supersystem.getInstance().ahrs.reset();
//		Supersystem.getInstance().reset(true);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		Supersystem.getInstance().rightenc.reset();
		Supersystem.getInstance().ahrs.reset();
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Supersystem.getInstance().rightenc.reset();
		Supersystem.getInstance().ahrs.reset();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().rightenc.reset();
		Supersystem.getInstance().ahrs.reset();
		// TODO Auto-generated method stub
		
	}
}
