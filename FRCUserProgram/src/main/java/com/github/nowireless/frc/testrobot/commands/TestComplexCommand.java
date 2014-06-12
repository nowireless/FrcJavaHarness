
package com.github.nowireless.frc.testrobot.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.type.StringArray;

/**
 *
 * @author bradmiller
 */
public class TestComplexCommand extends CommandBase {

    public TestComplexCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	log("Getting sdauto table");
    	NetworkTable table = NetworkTable.getTable("sdauto");
    	StringArray array = new StringArray();
    	
    	array.add("p0");
    	array.add("p1");
    	array.add("p2");
    	
    	table.putValue("cmdList", array);    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
