package org.usfirst.frc.team399.Config;

public class Ports {
	
	public static class Controls{
		public static int Driver_Joystick_1 = 0;
		public static int Driver_Joystick_2 = 1;
		public static int Driver_Joystick_OperatorGamepad = 2;
		
	}
	
	public static class DriveTrain{
		public static int Left_1_ID = 11;
		public static int Left_2_ID = 12;
		public static int Right_1_ID = 5;
		public static int Right_2_ID = 6;
	} 
	
	public static class InNOuttake{
		public static int INTAKE1_ID =  4;
		public static int INTAKE2_ID =  9;
		public static int OUTTAKE1_ID = 3;
		public static int OUTTAKE2_ID = 10;
		
		//standing in front of Impulse leftintake is 1, right intake is 2
		// left black outtake roller is outtake 1, and top right outtake is outtake 2
		
	}
	
	public static class GearManipulator{
		public static int GM1_ID;
		public static int GM2_ID;
		public static int GM1_DI_ID;
		public static int GM2_DI_ID;
		
	}
	
	public static class GearPickup{
		public static int GP1_ID = 8;
		public static int GP2_ID = 2;
		public static int GP1_DI_ID = 5;
		
		
	}
	
	public static class Climber{
		public static int CLimber1_ID = 1 ;
		public static int Climber2_ID = 7 ;
	}
	
	public static class Encoders{
		public static final int LeftEnc_a = 1;
		public static final int LeftEnc_b = 2;
		public static final int GPEnc_a = 3;
		public static final int GPEnc_b = 4;
	}
}
