package org.usfirst.frc.team399.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team399.Commands.testPulse;
import org.usfirst.frc.team399.Systems.Supersystem;
public class Test extends CommandGroup {
	public Test(){
		this.addSequential(new testPulse(-60,15.0));

	}
	
}
