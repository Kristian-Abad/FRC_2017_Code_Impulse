package org.usfirst.frc.team399.Commands;

import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.Command;

public class PegGear extends Command{

	boolean btn1;
	boolean btn2;
	double timeout;
	
	public PegGear(double timeout){
		this.timeout = timeout;
	}
	@Override
	protected void initialize() {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		boolean btn1 = Supersystem.getInstance().gmbut1.get();
		boolean btn2 = Supersystem.getInstance().gmbut2.get();
//		Supersystem.getInstance().gm.autonRunGearManipulator(btn1, btn2);
		Supersystem.getInstance().gm.UpdatedRunGearManipulator(true, false, btn1, btn2);
		setTimeout(timeout);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}

	@Override
	protected void end() {
		Supersystem.getInstance().gm.UpdatedRunGearManipulator(true, false, btn1, btn1);
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		Supersystem.getInstance().gm.UpdatedRunGearManipulator(true, false, btn1, btn1);
		// TODO Auto-generated method stub
		
	}

}
