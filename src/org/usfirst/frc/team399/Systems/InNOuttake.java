package org.usfirst.frc.team399.Systems;

import com.ctre.CANTalon;
public class InNOuttake {
	CANTalon intake1;
	CANTalon intake2;
	CANTalon outtake1;
	CANTalon outtake2;
	
	public InNOuttake(int LeftIntID1, int LeftIntID2, int RightOutID1, int RightOutID2){
		intake1 = new CANTalon(LeftIntID1);
		intake2 = new CANTalon(LeftIntID2);
		outtake1 = new CANTalon(RightOutID1);
		outtake2 = new CANTalon(RightOutID2);
	}
	
	public void runInNOuttake(double value){
		if(value == 1){
			//intake
			intake1.set(value);
			intake2.set(value);
			outtake2.set(-0.5); //this is intake on Impulse?
		}else if(value == -1){
			//outtake
			intake1.set(-value);
			intake2.set(-value);
			outtake1.set(-value);
			outtake2.set(-value);
		}else if(value == 2){
			intake1.set(-1);
			intake2.set(-1);
		}else if(value == 3){
			outtake1.set(-0.70);
			outtake2.set(-0.70);
		}else {
			intake1.set(0.0);
			intake2.set(0.0);
			outtake1.set(0.0);
			outtake2.set(0.0);
		}

		
	}
	
	public void reverseOuttakeRoller(boolean run){
		if(run){
			outtake1.set(-1);
		}else{
			outtake1.set(0.0);
		}
	}
	
	public void reverseIntake(int run ){
		if(run == 90){
			intake1.set(-1);
			intake2.set(-1);
		}else{
			intake1.set(0.0);
			intake2.set(0.0);
		}
	}

}
