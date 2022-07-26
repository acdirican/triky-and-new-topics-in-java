package com.acdirican.trickies.run_time;


import java.io.IOException;

/**
 * Runtime class is for interaction runtime Java environment. You can execute a process, invoke GC 
 * and get statistics about memory. 
 * 
 * It is in java.lang and it has only one instance java.lang.RunTime. You uses getInstance() method
 * to access the only instance.
 * 
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class Main {
	/**
	 * Print runtime statistics.
	 */
	public static void statistics() {
		Runtime  runtime = Runtime.getRuntime();
		long MB = 1024 *1024;
		System.out.println("Free memory in JVM:" + runtime.freeMemory()/MB + " MB");
		System.out.println("Max memory in JVM:" + runtime.maxMemory()/MB);
		System.out.println("Number of processors:" + runtime.availableProcessors());
	}
	
	/**
	 * Executes a given program
	 * @param programName the name of the program
	 */
	public static void run(String programName) {
		Runtime  runtime = Runtime.getRuntime();
		try {
			runtime.exec(programName);
		} catch (IOException e) {
			System.out.println("Program could not be runned!");
		}
	}
	public static void main(String[] args) {
		statistics();
		run("notepad");
		run("mspaint");
		//run("shutdown -s -t 0");  //windows, shutdown the computer
		//run("shutdown -r -t 0");  //windows, shutdown the computer
		
	}
}
