package try_catch;

/**
 * Finally almost means that "Whatever the case, run the code!".
 * 
 * It is generally used to execute clean up code like closing connections, 
 * closing files, or freeing up threads, as it executes regardless of an exception.
 * 
 * JVM always runs the code in the finally block after try or catch.
 * 
 * There are few situations where finally block does not run: JVM stops
 * , invoking System.exit, invoking Runtime.halt, in a Deamon thread.

 * 
 * @author Ahmet Cengizhan Dirican
 *
 */
public class Finally {
	
	/*Finally block runs no-matter an exception has been thrown or not */
	public static void printAsInteger(String number) {
		System.out.println("-------------------");
		try {
		    System.out.println("The number is " + Integer.parseInt(number));
		} catch (NumberFormatException e) {
		    System.out.println("Wrong number format!");
		} finally {
		    System.out.println("Number has been printed");
		}
		System.out.println("-------------------");
	}
	
	/* Try without a catch */
	/*Finally block runs even if you do return from the function */
	public static double calcSquare(double number) {
		System.out.println("-------------------");
		try {
		    return Math.pow(number, 2);
		} finally {
			
		    System.out.println("I can still work even if you return :-).");
		    System.out.println("-------------------");
		}
		
	}
	
	/*Finally block runs even if you don't catch an exception*/
	public static double defaultNumber() {
		System.out.println("-------------------");
		try {
		    return Math.pow(Double.parseDouble("ABC"), 2);
		} finally {
		    System.out.println("I can still work even if you don't catch the exception :-)."
		    		+ "But if you still don't catch the exception out of the function,  you program "
		    		+ "will stop!");
		    System.out.println("-------------------");
		}
		
	}
	public static void main(String[] args) {	
		printAsInteger("145");
		
		printAsInteger("ABC");
		
		double result = calcSquare(55);
		System.out.println("Squared -> 55^2 = " + result);
		
		double def = defaultNumber();
		
		
		
	}
}
