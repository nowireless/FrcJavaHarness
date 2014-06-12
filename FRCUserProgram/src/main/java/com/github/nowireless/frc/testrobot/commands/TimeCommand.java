
package com.github.nowireless.frc.testrobot.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author bradmiller
 */
public class TimeCommand extends CommandBase {
	private Timer timer = new Timer();
	private double time = 0.0;

    public TimeCommand(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	System.out.println("Initializing Time Command for time " + time +"s");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println("Time: " +timer.get());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= time;
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();
    	System.out.println("The Time has been reached");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
