package com.github.nowireless.frc.console;

import java.io.Console;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class FakeRobotConsole {
	public static void main(String[] args) {
		if(args.length != 1) {
			log("Format: console host");
			System.exit(-1);
		}
		Console console = System.console();
		if(console == null) {
			log("Console is null, ending");
			System.exit(-2);
		}
		
		NetworkTable.setIPAddress(args[0]);
		NetworkTable.setClientMode();
		log("Fake Robot Address:" + args[0]);
		
		NetworkTable table = NetworkTable.getTable("DS");
		
		while(true) {
			String in = console.readLine(":>");
			String cmd = in.toLowerCase();
			
			switch (cmd) {
			case "exit":
				log("Exiting");
				System.exit(0);
				break;
			case "status":
				log(formatStatus(table));
				break;
			case "telop":
				log("Selecting TeleOp");
				table.putBoolean("telop", true);
				break;
			case "auto":
				log("Selecting Auto");
				table.putBoolean("telop", false);
				break;
			case "enable":
				log("Enabling");
				table.putBoolean("enabled", true);
				break;
			case "disable":
				log("Disabling");
				table.putBoolean("enabled", false);
				break;
			case "start":
				log("Starting Robot");
				table.putBoolean("robotRun", true);
				break;
			case "stop":
				log("stoping Robot");
				table.putBoolean("robotRun", false);
				break;
			case "help":
				log("TODO");
				break;
			default:
				if(cmd.length() >= 1) {
					log("Bad Command");
				}
				break;
			}
			
		
		}
		
		
	}
	
	public static void log(String msg) {
		System.out.println(msg);
	}
	
	public static String formatStatus(NetworkTable table) {
		String state = "";
		if(table.getBoolean("telop")) {
			state = "Teleop";
		} else {
			state = "Auto";
		}
		
		String enableState = "";
		if(table.getBoolean("enabled")) {
			enableState = "Enabled";
		} else {
			enableState = "Disabled";
		}
		
		String runState = "";
		if(!table.getBoolean("robotRun")) {
			runState = "Not Running";
		} else {
			runState = "Running";
		}
		return "Status: " + runState + " , " + state + " " + enableState;
	}
}
