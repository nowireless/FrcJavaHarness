
package com.github.nowireless.frc.testrobot.commands;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PrintCommand;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.type.StringArray;

/**
 *
 * @author bradmiller
 */
public class SDAutoCommand extends CommandBase {
	
	private NetworkTable m_table = NetworkTable.getTable("sdauto");
	
	private ArrayList<Command> m_cmdList = null;
	
	private static final int kLoopSkip = 2;
	
	private boolean m_canEnd;
	private int m_currentCommandNumber = 0;
	private int m_runCount;
	private Command m_currentCommand;
	
    public SDAutoCommand() {
    	m_canEnd = false;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_canEnd = false;
    	m_currentCommandNumber = 0;
    	m_runCount = 0;
    	StringArray cmdArray = new StringArray();
    	m_table.retrieveValue("cmdList", cmdArray);
    	
    	if(cmdArray.size() == 0) {
    		m_canEnd = true;
    		log("Cmd Array is empty");
    		return;
    	}
    	
    	log("Cmd List Size: " + cmdArray.size());
    	
    	m_cmdList = new ArrayList<Command>();
   
    	for(int i = 0; cmdArray.size() > i; i++) {
    		String cmdName = cmdArray.get(i);
    		Command cmd = null;
    		
    		switch (cmdName) {
			case "p0":
				//cmd = new PrintCommand("Print:0");
				cmd = new TimeCommand(1.0);
				break;
			case "p1":
				//cmd = new PrintCommand("Print:1");
				cmd = new TimeCommand(2.0);
				break;
				
			case "p2":
				//cmd = new PrintCommand("Print:2");
				cmd = new TimeCommand(3.0);	
				break;

			default:
				log("Unknown cmd: " + cmdName);
				break;
			}
    		
    		if(cmd != null && m_cmdList != null) {
    			log("Added: "+ cmdName + "at " + i);
    			m_cmdList.add(cmd);
    		}
    	}
    	
    	
    	if(!m_cmdList.isEmpty()) {
    		log("Setting command 0 as current");
    		m_currentCommand = m_cmdList.get(0);
    	} else {
    		log("No Commands");
    		m_canEnd = true;
    		return;
    	}
    	m_currentCommand.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(m_runCount > kLoopSkip) {
    		if(!m_currentCommand.isRunning()) {
    			m_currentCommandNumber++;
    			if(m_currentCommandNumber > m_cmdList.size() - 1 ) {
    				log("No more commands to run");
    				m_canEnd = true;
    				return;
    			}
    			log("Command " + m_currentCommandNumber + " is done, moving to next");
    			m_currentCommand = m_cmdList.get(m_currentCommandNumber);
    			m_currentCommand.start();
    			m_runCount = 0;
    		}
    	} else {
    		m_runCount++;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return m_canEnd;
    }

    // Called once after isFinished returns true
    protected void end() {
    	m_cmdList.clear();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    
}
