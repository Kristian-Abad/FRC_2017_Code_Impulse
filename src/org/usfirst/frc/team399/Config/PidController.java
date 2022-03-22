package org.usfirst.frc.team399.Config;

public class PidController {
//	final double kP = 0.003;
//	final double kI = 0.0;
//	final double kD = 0.0;
	
	double p;
	double d; 
	
	double i =0;
	double lastError = 0;
	double value;
	double setPoint;
	double output;
	
	public double PIDgetoutput(double kP,double kI, double kD, double setpoint, double sensorvalue){
		p = setpoint - sensorvalue;
		i += p;
		d = p - lastError;
		lastError = p;
		output = (kP * p + kI * i + kD * d);
		
		return output;
		
	}

}
