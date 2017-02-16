package org.usfirst.frc.team2609.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This sample program shows how to control a motor using a joystick. In the
 * operator control part of the program, the joystick is read and the value is
 * written to the motor.
 *
 * Joystick analog values range from -1 to 1 and speed controller inputs also
 * range from -1 to 1 making it easy to work together. The program also delays a
 * short time in the loop to allow other threads to run. This is generally a
 * good idea, especially since the joystick values are only transmitted from the
 * Driver Station once every 20ms.
 */
public class Robot extends SampleRobot {
	
														// Talon on channel 0
	private Joystick stick = new Joystick(0);
	
	
    public static JoystickButton button1;// Button 1 is used in Drivetrain.java to 1/2 speed of driving/turning of the robot while held
    public static JoystickButton button2;
    public static JoystickButton button3;
    public static JoystickButton button4;
    public static JoystickButton button5;
    public static JoystickButton button6;
    public static JoystickButton button7;
    public static JoystickButton button9;
    public static JoystickButton button10;

    public static CANTalon driveMotor;
    
    public JoystickButton controlMotorF;
    public JoystickButton controlMotorB;
    
	private final double kUpdatePeriod = 0.005; // update every 0.005 seconds/5
												// milliseconds (200Hz)

	public Robot() {
		//SmartDashboard.putNumber("Talon ID", 0);
		SmartDashboard.putNumber("Drive Motor Speed", 0);
	    Robot.driveMotor = new CANTalon((int) SmartDashboard.getNumber("Talon ID", 1));
	    Robot.driveMotor.changeControlMode(TalonControlMode.PercentVbus);
		//Robot.driveMotor = driveMotor;
	}

	/**
	 * Runs the motor from a joystick.
	 */
	@Override
	public void operatorControl() {
		while (isOperatorControl() && isEnabled()) {
			// Set the motor's output.
			// This takes a number from -1 (100% speed in reverse) to +1 (100%
			// speed going forward)
			//motor.set(stick.getY());
			
			controlMotorF = new JoystickButton(stick, 4);
			controlMotorB = new JoystickButton(stick, 2);
			if (controlMotorF.get()){
				driveMotor.set(SmartDashboard.getNumber("Drive Motor Speed",0));
			}
			else if (controlMotorB.get()){
				driveMotor.set(-SmartDashboard.getNumber("Drive Motor Speed",0));
			}
			else{
				driveMotor.set(0);
			}
			

			Timer.delay(kUpdatePeriod); // wait 5ms to the next update
		}
	}
}
