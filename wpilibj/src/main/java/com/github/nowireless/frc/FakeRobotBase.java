package com.github.nowireless.frc;

import java.util.logging.Level;
import java.util.logging.Logger;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class FakeRobotBase {
	protected DriverStation m_ds;
    private boolean m_robotRunning;
    private Logger m_logger = Logger.getLogger("FakeRobot");
    
    public  void log(String msg) {
    	m_logger.log(Level.INFO, msg);
    }
    
	public void initNetTables() {
		NetworkTable.setServerMode();
		NetworkTable.getTable("");
		m_ds = DriverStation.getInstance();
	}
	
	
	public FakeRobotBase() {
		initNetTables();
		m_robotRunning = false;
	}
	
	public boolean isRobotRunnig() {
		return m_ds.isRobotRunning();
	}
	
	/*public void stopRobot() {
		m_robotRunning = false;
	}
	
	public void enableRobot() {
		m_robotRunning = true;
	}*/
	
    /**
     * @return If the robot is running in simulation.
     */
    public static boolean isSimulation() {
        return true;
    }

    /**
     * @return If the robot is running in the real world.
     */
    public static boolean isReal() {
        return false;
    }

    /**
     * Determine if the Robot is currently disabled.
     *
     * @return True if the Robot is currently disabled by the field controls.
     */
    public boolean isDisabled() {
        return m_ds.isDisabled();
    }

    /**
     * Determine if the Robot is currently enabled.
     *
     * @return True if the Robot is currently enabled by the field controls.
     */
    public boolean isEnabled() {
        return m_ds.isEnabled();
    }

    /**
     * Determine if the robot is currently in Autonomous mode.
     *
     * @return True if the robot is currently operating Autonomously as
     * determined by the field controls.
     */
    public boolean isAutonomous() {
        return m_ds.isAutonomous();
    }

    /**
     * Determine if the robot is currently in Test mode
     *
     * @return True if the robot is currently operating in Test mode as
     * determined by the driver station.
     */
    public boolean isTest() {
        return m_ds.isTest();
    }

    /**
     * Determine if the robot is currently in Operator Control mode.
     *
     * @return True if the robot is currently operating in Tele-Op mode as
     * determined by the field controls.
     */
    public boolean isOperatorControl() {
        return m_ds.isOperatorControl();
    }
	
}