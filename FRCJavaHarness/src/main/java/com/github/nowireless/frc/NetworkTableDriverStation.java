package com.github.nowireless.frc;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class NetworkTableDriverStation extends DriverStation{
	
	private NetworkTable table = null;
	
	public NetworkTableDriverStation() {
		
	}
	
	public void initNetTables()  {
		table = NetworkTable.getTable("DS");
		table.putBoolean("enabled", false);
		table.putBoolean("telop", true);
		table.putBoolean("robotRun", false);
	}
	
	
	@Override
	public void updateState() {
		this.setState(table.getBoolean("robotRun", false), table.getBoolean("enabled", false), table.getBoolean("telop", true));
	}

	@Override
	public void init() {

	}

	
	
}
