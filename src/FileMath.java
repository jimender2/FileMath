import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Jonathan Meredith
 * This program takes input from the user to get a file location and then it 
 * reads in arithmetic expressions from the file.  It performs these
 * expressions and then it writes the results to a new file.
 *
 */

public class FileMath {

	public static void main(String[] args) throws IOException {
		
		//Get Scanner Ready
		Scanner scan = new Scanner(System.in);
		
		//Initialize variables
		String operator;
		
		int total = 0;
		int one = 0;
		int two = 0;
		
		double doubleTotal = 0.00;
		
		//Get File Location
		System.out.println("Please enter where the input file can be found.");
		String inputFile = scan.nextLine();
		
		//Create result file
		String outputName = "result_" + inputFile;
	    PrintWriter outputFile = new PrintWriter(outputName);
	    
	    //Read input file
		File file = new File(inputFile);
	    Scanner input = new Scanner(file);
		
	    //Loop through every line in the file
		while (input.hasNext()) {
			one = input.nextInt();
			operator = input.next();
			two = input.nextInt();
			
			//Check what type of problem it is
			switch (operator){
				case "+":
					total = one + two;
					outputFile.println(one + " " + operator + " " + two + 
							" = " + total);
					break;
				case "-":
					total = one - two;
					outputFile.println(one + " " + operator + " " + two +
							" = " + total);
					break;
				case "*":
					total = one * two;
					outputFile.println(one + " " + operator + " " + two +
							" = " + total);
					break;
				case "/":
					doubleTotal = (one + 0.00) / (two + 0.00);
					outputFile.printf("%d %s %d = %.2f \n", one, operator,
							two, doubleTotal);
					break;
				case "%":
					total = one % two;
					outputFile.println(one + " " + operator + " " + two +
							" = " + total);
					break;
				default:
					System.out.println("Problem is not valid");
			}		    
			
		}

		//Close the input and output streams
		scan.close();
		outputFile.close();
		input.close();

		//Tell the user when the result file is finished
		System.out.println( "File " + outputName + " has been written to"
				+ " disk.");

	}

}
