package com.github.nowireless.frc;

import com.github.nowireless.frc.userprogram.UserProgram;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;

public class Harness {
	

	public static void main(String[] args) {
		System.out.println("Creating Fake Robot");
		
		NetworkTableDriverStation ntds = new NetworkTableDriverStation();
		DriverStation.setDS(ntds);
		IterativeRobot robot = UserProgram.getNewInstance();
		ntds.initNetTables();
		
		DriverStation ds = DriverStation.getInstance();
		
		System.out.println("Waiting for robot to be allowed to run");
		while(!ds.isRobotRunning()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Starting Robot");
		robot.startCompetition();
		System.out.println("Robot has ended Competition");
		
		System.exit(0);
	}

}
