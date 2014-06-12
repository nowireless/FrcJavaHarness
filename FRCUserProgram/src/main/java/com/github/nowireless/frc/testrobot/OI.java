
package com.github.nowireless.frc.testrobot;

import com.github.nowireless.frc.testrobot.commands.SDAutoCommand;
import com.github.nowireless.frc.testrobot.commands.TestComplexCommand;
import com.github.nowireless.frc.testrobot.commands.TimeCommand;

import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public OI() {
		SmartDashboard.putData("Print Command", new PrintCommand("Hello World"));
		SmartDashboard.putData("Time Command", new TimeCommand(5.0));
		SmartDashboard.putData("Complex Test", new TestComplexCommand());
		SmartDashboard.putData("SD Auto Test", new SDAutoCommand());
	}
}