package edu.wpi.first.wpilibj;

public abstract class DriverStation {
	
	private boolean enabled = false;
	private boolean telop = true;
	private boolean robotRun = false;
	
	private static DriverStation m_ds;
	public static void setDS(DriverStation ds) {
		m_ds = ds;
	}
	
	public static DriverStation getInstance() {
		return m_ds;
	}
	
	
	public DriverStation() {
		init();
	}
	
	public abstract void init();
	public abstract void updateState();
	
	
	protected void setState(boolean robotRun, boolean enabled, boolean telop) {
		this.enabled = enabled;
		this.telop = telop;
		this.robotRun = robotRun;
	}
	
	public boolean isEnabled() {
		this.updateState();
		return enabled;
	}
	
	public boolean isDisabled() {
		this.updateState();
		return !enabled;
	}
	
	public boolean isAutonomous() {
		this.updateState();
		return !telop;
	}
	
	public boolean isTest() {
		this.updateState();
		return false;
	}
	
	public boolean isOperatorControl() {
		this.updateState();
		return telop;
	}
	
	public boolean isRobotRunning() {
		this.updateState();
		return robotRun;
	}
}
