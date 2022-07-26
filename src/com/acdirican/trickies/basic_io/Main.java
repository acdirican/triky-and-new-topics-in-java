package com.acdirican.trickies.basic_io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Java I/O is normally a huge topic. This class includes methods for frequent operations 
 * conducted with text file.
 * 
 * Notes:
 * 
 * #Files and Path
 * Java NIO Files and Path classes ease file and directory operations.
 * 
 * 
 * #Reading:
 * Scanner and BufferReader both classes are used to read input from external system. 
 * 	
 *   Scanner is normally used when we know input is of type string or of primitive types. 
 * It has specific nextXXX methods for primitve data types and String. Therefore, it can allow us 
 * to easily convert the data into a specified data type.
 *  
 *   BufferReader is used to read text from character streams while buffering the characters 
 * for efficient reading of characters.
 * It permits to read a text from file, with bytes converted in characters. 
 * It allows to read line by line.
 * 
 * #Writing:
 * 
 *    PrintWriter is the most enhanced Writer to write Character data to a file.
 * It has printXXX like methods on any Writer in character mode. 
 * It is essentially used to write to a file just like System.out to write to the console.
 * Actually System.out is printWriter.
 * It can direct use the file path
 * 
 * 
 *    A BufferedWriter is more efficient by using a buffered methods. 
 * It will buffer the characters in Java memory before (probably, depending on the implementation) 
 * dropping to C to do the writing to the file.
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class Main {
	
	/*
	 * The easiest way to read a text files
	 */
	public static List<String> readTextFile(String filePath){
		try {
			return Files.readAllLines(Path.of(filePath));
		} catch (IOException e) {
			System.err.println("File could not be read");
		}
		
		return null;
	}
	
	/*
	 * Using Scanner
	 */
	public static List<Integer> readFormattedTextFile1(String filePath){
		List<Integer> data =  null;
		try ( Scanner scanner =  new Scanner(Path.of(filePath).toFile())) { //no need to close the scanner
			 data =  new ArrayList<>();
			while(scanner.hasNext()) {
				data.add(scanner.nextInt());
			}
			return data;
		} catch (FileNotFoundException e) {
			System.err.println("File could not be read");
		}
		return null;
	}
	
	/*
	 * Using BaufferedReader
	 */
	public static List<Integer> readFormattedTextFile2(String filePath){

		List<Integer> data =  null;
		try (FileReader fileReader =  new  FileReader(filePath);
			BufferedReader reader =  new BufferedReader(fileReader)) { //no need to close readers
			 data =  new ArrayList<>();
			while(reader.ready()) {
				data.add(Integer.parseInt(reader.readLine()));
			}
			return data;
		} catch (FileNotFoundException e) {
			System.err.println("File could not be read!");
		} catch (NumberFormatException e) {
			System.err.println("Number converison error!");
		} catch (IOException e) {
			System.err.println("I/O problem!");
		}
		return null;
	}
	
	/*
	 * Using BaufferedReader and Stream API
	 */
	public static List<Integer> readFormattedTextFile3(String filePath){
		
		try (FileReader fileReader =  new  FileReader(filePath);
				
			BufferedReader reader =  new BufferedReader(fileReader)) { //no need to close readers
			return reader.lines().map( s -> Integer.parseInt(s)).toList();
			
		} catch (FileNotFoundException e) {
			System.err.println("File could not be read!");
		} catch (NumberFormatException e) {
			System.err.println("Number converison error!");
		} catch (IOException e) {
			System.err.println("I/O problem!");
		}
		return null;
	}
	
	/*
	 * Using BaufferedWriter 
	 */
	public static void writeFormatteddata1(String filePath, List<Integer> data){
	
		try (FileWriter fileWriter =  new FileWriter(filePath);
			BufferedWriter bufferedWriter =  new BufferedWriter(fileWriter)) { //no need to close readers
			
			for(Integer i :data) {
				bufferedWriter.write(i*i + "\n");
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("File could not be read!");
		} catch (IOException e) {
			System.err.println("I/O problem!");
		}
		finally {
			System.out.println("If no error, find and read the file " + filePath + " by refreshing the project");
		}

	}
	
	
	/*
	 * Using BaufferedWriter 
	 */
	public static void writeFormatteddata2(String filePath, List<Integer> data){
	
		try (PrintWriter printWriter = new PrintWriter(filePath)) { //no need to close readers
			
			for(Integer i :data) {
				printWriter.write(i*i + "\n");
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("File could not be read!");
		} catch (IOException e) {
			System.err.println("I/O problem!");
		}
		finally {
			System.out.println("If no error, find and read the file " + filePath + " by refreshing the project");
		}

	}
	public static void main(String[] args) {
		List<String> lines = readTextFile("test.txt");
		System.out.println(lines);	
		
		List<Integer> data1 = readFormattedTextFile1("data.txt");
		System.out.println(data1);	
		
		List<Integer> data2 = readFormattedTextFile2("data.txt");
		System.out.println(data2);	
		
		List<Integer> data3 = readFormattedTextFile2("data.txt");
		System.out.println(data3);
		
		writeFormatteddata1("dataOut1.txt", data3);
		System.out.println("Result:" + readFormattedTextFile1("dataOut1.txt"));
		
		writeFormatteddata1("dataOut2.txt", data3);
		System.out.println("Result:" + readFormattedTextFile1("dataOut2.txt"));
		 
		printDirectory("aaa");
		printDirectory("test.txt");
		//printDirectory(Paths.get("").toAbsolutePath().toString()); //may cause acces denied
		//printDirectory(System.getProperty("user.home")); //may cause acces denied
	}
	
	public static void printDirectory(String directoryPath) {
		Path p = Path.of(directoryPath);
		
		if (Files.exists(p, LinkOption.NOFOLLOW_LINKS)) {
			if (Files.isDirectory(p, LinkOption.NOFOLLOW_LINKS)) {
				try {
					Files.lines(Path.of(directoryPath)).forEach(System.out::println);
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("I/O Error!");
				}
			}
			else {
				System.err.println(directoryPath + " is not a directory.");
			}
			
		}
		else {
			System.err.println(directoryPath + " does not exist");
		}
		
	}
}
