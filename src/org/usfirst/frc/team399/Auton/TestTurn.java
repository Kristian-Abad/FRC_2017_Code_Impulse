package org.usfirst.frc.team399.Auton;

import org.usfirst.frc.team399.Commands.TurntoAngle;
import org.usfirst.frc.team399.Systems.Supersystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TestTurn extends CommandGroup {
	public TestTurn(){
		double angle = Supersystem.getInstance().ahrs.getAngle();
		this.addSequential(new TurntoAngle(-60,15.0));
	}
}
