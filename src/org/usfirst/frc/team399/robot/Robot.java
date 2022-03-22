package org.usfirst.frc.team399.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team399.Config.Ports;
import org.usfirst.frc.team399.Systems.Supersystem;
import org.usfirst.frc.team399.Auton.DriveStraight2;
import org.usfirst.frc.team399.Auton.DriveStraight3;
import org.usfirst.frc.team399.Auton.RedAllianceAwayFromBoilerOperationRichard;
import org.usfirst.frc.team399.Auton.RedAllianceBoilerGear;
import org.usfirst.frc.team399.Auton.RedAllianceRunOuttake;
import org.usfirst.frc.team399.Auton.RefinedDriveStraight1;
import org.usfirst.frc.team399.Auton.RefinedDriveStraight3;
import org.usfirst.frc.team399.Auton.RunOuttake;
import org.usfirst.frc.team399.Auton.Test;
import org.usfirst.frc.team399.Auton.TestTurn;
import org.usfirst.frc.team399.Auton.BaselineAuton;
import org.usfirst.frc.team399.Auton.BlueAllianceAwayFromBoilerOperationRichard;
import org.usfirst.frc.team399.Auton.BlueAllianceBoilerGear;
import org.usfirst.frc.team399.Auton.BlueAllianceRunOuttake;
import org.usfirst.frc.team399.Auton.DoNothing;
import org.usfirst.frc.team399.Auton.DriveStraight1;
import org.usfirst.frc.team399.Commands.PegGear;
import org.usfirst.frc.team399.Commands.TurntoAngle;



public class Robot extends IterativeRobot {
	SendableChooser autonchooser = new SendableChooser();
	Command autonomousCommand;
	
	Supersystem Bot = Supersystem.getInstance();
	Joystick Driverleft = new Joystick(Ports.Controls.Driver_Joystick_1);
	Joystick Driverright = new Joystick(Ports.Controls.Driver_Joystick_2);
	Joystick OperatorGamepad = new Joystick(Ports.Controls.Driver_Joystick_OperatorGamepad);

	@Override
	public void robotInit() {
//		autonchooser.addDefault("Do Nothing", new DoNothing());
////		autonchooser.addObject("Gear Pos.1 or Left Face", new DriveStraight1());
//		autonchooser.addObject("Gear Pos.1 or Left Face", new RefinedDriveStraight1());
//		autonchooser.addObject("Gear Pos.2 or Middle Face", new DriveStraight2());
//		autonchooser.addObject("Gear Pos.3 or Right Face", new RefinedDriveStraight3());
////		autonchooser.addObject("Gear Pos.3 or Right Face", new DriveStraight3());
//		autonchooser.addObject("Red Alliance: Run Outtake-Baseline", new RedAllianceRunOuttake());
//		autonchooser.addObject("Blue Alliance: Run Outtake-Baseline", new BlueAllianceRunOuttake());
//		autonchooser.addObject("Red Alliance: Run Outtake-Gear (Test(s) needed)", new RedAllianceBoilerGear());
//		autonchooser.addObject("Blue Alliance: Run Outtake-Gear (Test(s) needed)", new BlueAllianceBoilerGear());
//		autonchooser.addObject("Red Alliance: Run Op. Richard Away From Boiler (Test(s) needed)", new RedAllianceAwayFromBoilerOperationRichard());
//		autonchooser.addObject("Blue Alliance: Run Op. Richard Away From Boiler (Test(s) needed)", new BlueAllianceAwayFromBoilerOperationRichard());
//		autonchooser.addObject("Baseline Auton", new BaselineAuton());
//		autonchooser.addObject("Just Outtake", new RunOuttake());

		
		SmartDashboard.putData("Auto choices", autonchooser);
		
		CameraServer.getInstance().startAutomaticCapture();
		
	}

	@Override
	public void autonomousInit() {
		
		autonomousCommand = (Command) autonchooser.getSelected();
		if(autonomousCommand != null){
			autonomousCommand.start();
			System.out.println("Chosen auton:" + autonomousCommand);
		}
		
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopPeriodic() {
		Bot.drive.tankDrive(Driverleft.getRawAxis(1), Driverright.getRawAxis(1));
		Bot.innouttake.runInNOuttake(OperatorGamepad.getPOV() == 180 ? 1 : OperatorGamepad.getPOV() == 0 ? -1 : OperatorGamepad.getPOV() == 90 ? 2 : OperatorGamepad.getPOV() == 270 ? 3 : 0);
		Bot.climber.runClimb(OperatorGamepad.getRawButton(2) ? 1 : 0);
		
//		Celebrate America modification
//		Bot.innouttake.runInNOuttake(Driverright.getRawButton(11) ? -1 : 0);
		Bot.gp.runGearPickup(OperatorGamepad.getRawButton(5), OperatorGamepad.getRawButton(6), Bot.gpbut1.get(),OperatorGamepad.getRawButton(7),OperatorGamepad.getRawButton(8), Bot.gpencoder.getDistance());
//		Bot.gm.runGearManipulator(OperatorGamepad.getRawButton(5),OperatorGamepad.getRawButton(6),Bot.gmbut1.get(),Bot.gmbut2.get());
//		Bot.innouttake.reverseIntake(OperatorGamepad.getPOV() == 90 ? -1 : 0);
		
//		test this
//		if(OperatorGamepad.getRawButton(1)){
//			Bot.ahrs.reset();
//			Bot.rightenc.reset();
//		}else {
//			
//		}
//		if(OperatorGamepad.getRawButton(4)){
//			Bot.drive.PIDTurn(Bot.ahrs.getAngle(), 90);
//			Bot.drive.backwardPID(36,0);
//		}else{
//			
//		}
//		
//		if(OperatorGamepad.getRawButton(3)){
//			Bot.drive.PIDTurn(Bot.ahrs.getAngle(),-90);
//			Bot.drive.forwardPID(36,0);
//		}else{
//			
//		}
		
//		System.out.println(Supersystem.getInstance().ahrs.getAngle());
		System.out.println("Pulses:" + Bot.rightenc.getDistance() + "Angle:" + Bot.ahrs.getAngle());
//		System.out.println(OperatorGamepad.getPOV());
	}

	@Override
	public void testPeriodic() {
		
	}
}

