package try_catch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Try-with-resources: Used to automatically close one or more resources at then end of the try block.
 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class TryWithResources {
	public static void main(String[] args) {
		covnentionalWayOfClosingAResource();
		tryWithResourcesClosignAResource();
		tryWithResourcesClosignMultipleResource();
	}

	private static void tryWithResourcesClosignMultipleResource() {
		try (Scanner scanner = new Scanner(new File("test.txt"));
				PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
			while (scanner.hasNext()) {
				writer.print(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void tryWithResourcesClosignAResource() {
		try (Scanner scanner = new Scanner(new File("test.txt"))) {
		    while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

	private static void covnentionalWayOfClosingAResource() {
		Scanner scanner = null;
		try {
		    scanner = new Scanner(new File("test.txt"));
		    while (scanner.hasNext()) {
		        System.out.println(scanner.nextLine());
		    }
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} finally {
		    if (scanner != null) {
		        scanner.close();
		    }
		}
		
	}
}
