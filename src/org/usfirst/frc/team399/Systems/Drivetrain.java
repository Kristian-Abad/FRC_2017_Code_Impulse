package org.usfirst.frc.team399.Systems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team399.Config.PidController;
import org.usfirst.frc.team399.Systems.Supersystem;

public class Drivetrain {
	
	private CANTalon lefta = null;
	private CANTalon leftb = null;
	private CANTalon righta = null;
	private CANTalon rightb = null;
	PidController pc;
	
	public Drivetrain(int la, int lb, int ra, int rb) {
		
		lefta = new CANTalon(la);
		leftb = new CANTalon(lb);
		
		righta = new CANTalon(ra);
		rightb = new CANTalon(rb);
		
		
	}
	
	public void tankDrive(double leftv, double rightv) {
		lefta.set(-leftv);
		leftb.set(-leftv);
		
		righta.set(rightv);
		rightb.set(rightv);
	}
	
	public void backwardPID(double targetDistanceInInches, double subtract){
		double newdist = targetDistanceInInches - subtract;
		double requiredPulses = newdist * 39.777247414;
		double currentPulses = Math.abs(Supersystem.getInstance().rightenc.getDistance());
		double currentAngle = Supersystem.getInstance().ahrs.getAngle();
		double scaledAngle = currentAngle*0.1;
		double kP = 0.003;
		double kI = 0.0;
		double kD = 0.0000000000000000000001;
		double p;
		double d; 
		
		double i =0;
		double lastError = 0;
		double value;
		double setPoint;
		double output;
	
		
		p = requiredPulses - currentPulses;
		i += p;
		d = p - lastError;
		lastError = p;
		output = (kP * p + kI * i + kD * d);
		
		double finaloutput1 = output + scaledAngle;
		double finaloutput2 = output - scaledAngle;
		lefta.set(-finaloutput1);
		leftb.set(-finaloutput1);
		righta.set(finaloutput2);
		rightb.set(finaloutput2);
	}
	
	public void forwardPID(double targetDistanceInInches, double subtract){
		double newdist = targetDistanceInInches - subtract;
		double requiredPulses = targetDistanceInInches * 39.777247414;
		double currentPulses = Math.abs(Supersystem.getInstance().rightenc.getDistance());
		double currentAngle = Supersystem.getInstance().ahrs.getAngle();
		double scaledAngle = currentAngle*0.1;
		double kP = 0.003;
		double kI = 0.0;
		double kD = 0.00000000000000001;
		double p;
		double d; 
		
		double i =0;
		double lastError = 0;
		double value;
		double setPoint;
		double output;
		
		p = requiredPulses - currentPulses;
		i += p;
		d = p - lastError;
		lastError = p;
		output = (kP * p + kI * i + kD * d);
		
		double finaloutput1 = output + scaledAngle;
		double finaloutput2 = output - scaledAngle;
		lefta.set(finaloutput1);
		leftb.set(finaloutput1);
		righta.set(-finaloutput2);
		rightb.set(-finaloutput2);
	}
	
	public void easyBackwardStraight(double currentPulses,double angle,double targetDistanceInInches){
		double requiredPulses = targetDistanceInInches * 42.335214866;
		double powpart = (requiredPulses - Math.abs(currentPulses));
		double newpow = powpart/4000;
		double reconAngle = angle*0.09;
		double leftpow = newpow + reconAngle;
		double rightpow = newpow - reconAngle;
		
		lefta.set(-leftpow);
		leftb.set(-leftpow);
		righta.set(rightpow);
		rightb.set(rightpow);
		
		
	}
	
	//added 
	public void easyForwardStraight(double currentPulses,double angle,double targetDistanceInInches){
		double requiredPulses = targetDistanceInInches * 42.335214866;
		double powpart = (requiredPulses - Math.abs(currentPulses));
		double newpow = powpart/4000;
		double reconAngle = angle*0.09;
		double leftpow = newpow - reconAngle;
		double rightpow = newpow + reconAngle;
		
		lefta.set(leftpow);
		leftb.set(leftpow);
		righta.set(-rightpow);
		rightb.set(-rightpow);
		
		
	}
	
	public void updatedTurnAngle(double currentAngle, double targetAngle){
		//double left = (targetAngle + currentAngle)*0.09;
		double pow = (targetAngle - currentAngle)*0.012;
		lefta.set(pow);
		leftb.set(pow);
		righta.set(pow);
		rightb.set(pow);
		
	}
	
	//test with controller
	public void PIDTurn(double currentAngle, double targetAngle){
		double kP = 0.04;
		double kI = 0.0;
		double kD = 0.02;
		double p;
		double d; 
		
		double i =0;
		double lastError = 0;
		double value;
		double setPoint;
		double output;
		
		p = targetAngle - currentAngle;
		i += p;
		d = p - lastError;
		lastError = p;
		output = (kP * p + kI * i + kD * d);
		lefta.set(output);
		leftb.set(output);
		righta.set(output);
		rightb.set(output);
	}
	
	public void easyForwardTurn(double currPulses, double currAngle, double targetInInches, double targetAngle){
		double requiredPulses = targetInInches * 42.335214866;
		double powpart = (requiredPulses - Math.abs(currPulses));
		double newpow = powpart/4000;
		double pow = (targetAngle - currAngle)*0.09;
		
		lefta.set(newpow);
		leftb.set(newpow);
		righta.set(-newpow);
		rightb.set(-newpow);
		
		if(Math.abs(currPulses) >= Math.abs(requiredPulses)){
			lefta.set(pow);
			leftb.set(pow);
			righta.set(pow);
			rightb.set(pow);
		}else{
			
		}
		
	}

	public void easyBackwardTurn(double currPulses, double currAngle, double targetInInches, double targetAngle){
		double requiredPulses = targetInInches * 42.335214866;
		double powpart = (requiredPulses - Math.abs(currPulses));
		double newpow = powpart/4000;
		double pow = (targetAngle - currAngle)*0.09;
		
		lefta.set(-newpow);
		leftb.set(-newpow);
		righta.set(newpow);
		rightb.set(newpow);
		
		if(Math.abs(currPulses) >= Math.abs(requiredPulses)){
			lefta.set(pow);
			leftb.set(pow);
			righta.set(pow);
			rightb.set(pow);
		}else{

		}
		
	}
	
	public void easyBackwardTurnBackward(double currPulses, double currAngle, double targetInInches,double secondtargetInInches, double targetAngle){
		boolean firststate = true;
		boolean secondstate = false;
		boolean thirdstate = false;
		double requiredPulses = targetInInches * 42.335214866;
		double powpart = (requiredPulses - Math.abs(currPulses));
		double newpow = powpart/4000;
		
		double secondrequiredPulses = targetInInches * 42.335214866;
		double secondpowpart = (requiredPulses - Math.abs(currPulses));
		double secondnewpow = secondpowpart/4000;
		double pow = (targetAngle - currAngle)*0.09;
		
		if(firststate){
			if(Math.abs(currPulses) < Math.abs(requiredPulses)){
				lefta.set(-newpow);
				leftb.set(-newpow);
				righta.set(newpow);
				rightb.set(newpow);
			}else if(Math.abs(currPulses) >= Math.abs(requiredPulses)){
				secondstate = true;
			}else{
				lefta.set(0.0);
				leftb.set(0.0);
				righta.set(0.0);
				rightb.set(0.0);
			}
		}else if(secondstate){
			lefta.set(pow);
			leftb.set(pow);
			righta.set(pow);
			rightb.set(pow);
			if(Math.abs(currAngle) >= Math.abs(targetAngle)){
				Supersystem.getInstance().rightenc.reset();
				thirdstate = true;
			}else{
				
			}
		}else if(thirdstate){
			lefta.set(-secondnewpow);
			leftb.set(-secondnewpow);
			righta.set(secondnewpow);
			rightb.set(secondnewpow);
		}else{
			lefta.set(0.0);
			leftb.set(0.0);
			righta.set(0.0);
			rightb.set(0.0);
		}
		
	}
	
	public void easyForwardTurnForward(double currPulses, double currAngle, double targetInInches,double secondtargetInInches, double targetAngle){
		boolean firststate = true;
		boolean secondstate = false;
		boolean thirdstate = false;
		double requiredPulses = targetInInches * 42.335214866;
		double powpart = (requiredPulses - Math.abs(currPulses));
		double newpow = powpart/4000;
		
		double secondrequiredPulses = targetInInches * 42.335214866;
		double secondpowpart = (requiredPulses - Math.abs(currPulses));
		double secondnewpow = secondpowpart/4000;
		double pow = (targetAngle - currAngle)*0.09;
		
		if(firststate){
			if(Math.abs(currPulses) < Math.abs(requiredPulses)){
				lefta.set(newpow);
				leftb.set(newpow);
				righta.set(-newpow);
				rightb.set(-newpow);
			}else if(Math.abs(currPulses) >= Math.abs(requiredPulses)){
				secondstate = true;
			}else{
				lefta.set(0.0);
				leftb.set(0.0);
				righta.set(0.0);
				rightb.set(0.0);
			}
		}else if(secondstate){
			lefta.set(pow);
			leftb.set(pow);
			righta.set(pow);
			rightb.set(pow);
			if(Math.abs(currAngle) >= Math.abs(targetAngle)){
				Supersystem.getInstance().rightenc.reset();
				thirdstate = true;
			}else{
				
			}
		}else if(thirdstate){
			lefta.set(secondnewpow);
			leftb.set(secondnewpow);
			righta.set(-secondnewpow);
			rightb.set(-secondnewpow);
		}else{
			lefta.set(0.0);
			leftb.set(0.0);
			righta.set(0.0);
			rightb.set(0.0);
		}
		
	}
	
	public void setZero(boolean zero, double currentAngle){
		if(zero){
			lefta.set(-currentAngle);
			leftb.set(-currentAngle);
			righta.set(currentAngle);
			rightb.set(currentAngle);
		}else{
			lefta.set(0.0);
			leftb.set(0.0);
			righta.set(0.0);
			rightb.set(0.0);
		}
		
	}
	
	public void arcadeDrive(double throttle, double turn){
		double left = throttle + turn;
		double right = throttle - turn;
		lefta.set(-left);
		leftb.set(-left);
		righta.set(right);
		rightb.set(right);
	}
	
	//For arcs need to make forward left arc, forward right arc, backward left arc, backward right arc
//	public void autonLeftArc(double throttle,double turn,double setpoint,double currentpoint,double divider){
//		double requiredPulses = setpoint * 42.335214866;
//		double powpart = (requiredPulses - Math.abs(currentpoint));
//		double value = powpart/divider;
//		double left = throttle + value;
//		double right = throttle - value;
//		lefta.set(-left);
//		leftb.set(-left);
//		righta.set(right);
//		rightb.set(right);
//	}
//	
//	public void autonRightArc(double throttle,double turn,double setpoint,double currentpoint,double divider){
//		double requiredPulses = setpoint * 42.335214866;
//		double powpart = (requiredPulses - Math.abs(currentpoint));
//		double value = powpart/divider;
//		double left = throttle - value;
//		double right = throttle + value;
//		lefta.set(-left);
//		leftb.set(-left);
//		righta.set(right);
//		rightb.set(right);
//	}
	
	public void limitSwitch(boolean leftfor,boolean leftrev,boolean rightfor,boolean rightrev){
		lefta.enableLimitSwitch(leftfor,leftrev);
		leftb.enableLimitSwitch(leftfor,leftrev);
		
		righta.enableLimitSwitch(rightfor,rightrev);
		rightb.enableLimitSwitch(rightfor,rightrev);
		
	}
	
}
