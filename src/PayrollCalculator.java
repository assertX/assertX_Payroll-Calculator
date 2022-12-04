package assignment_1;


import java.util.Scanner;

public class PayrollCalculation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String goAgain = "";
		
		//This allows me to make sure the user input is only digits between 0-9 and the + means 1 or more times.
		String regex = "\\d+";
		do {

			// Let the user enter required input data.
			  
			//This checks to make sure the user doesn't enter any integers or characters. Only letters.
			System.out.print("Enter your last name: ");
			while (!scanner.hasNext("[A-Za-z]+")) {
				System.out.print("Not a valid name! Try again: ");
				scanner.next();

			}
			String lastName = scanner.next();
			
			//This makes sure the user inputs 4 digits and no letters or characters.
			System.out.print("SSN (last 4 digits): ");
			String socialNum = scanner.next();
			while (true) {
				if (socialNum.length() == 4 && socialNum.matches(regex)) {
					break;
				}else {
					System.out.print("Please enter a valid 4 digit: ");
					socialNum = scanner.next();
				}
				
			}
			
			//Checks to makes sure only numbers are entered. This can also take whole numbers and floats.
			System.out.print("Hourly pay rate: ");
			while (!scanner.hasNextDouble()) {
				scanner.next();
				System.out.print("Enter a valid number: ");
			}
			double hourlyRate = scanner.nextDouble();
			
			//Checks to makes sure only numbers are entered. This can also take whole numbers and floats.
			System.out.print("Hours worked: ");
			while (!scanner.hasNextInt()) {
				scanner.next();
				System.out.print("Enter a valid number: ");
			}
			int hoursWorked = scanner.nextInt();

			// Calculations for the outputs
			double grossPay = hourlyRate * hoursWorked;
			double federalTax = 0.15 * grossPay;
			double stateTax = 0.05 * grossPay;
			double netPay = grossPay - federalTax - stateTax;

			// Gets the total length of characters(numbers), so the output will always be in
			// size not matter how big/small the gross pay number is.
			String grossPayString = String.format("%.2f", grossPay);
			int grossPayStringLength = grossPayString.length();

			// Output and calculate users info to screen
			System.out.println("\nPayroll Summary for: " + lastName);
			System.out.println("SSN (last 4 digits): " + socialNum);
			System.out.printf("You worked %s hours at $%.2f per hour.\n", hoursWorked, hourlyRate);

			System.out.printf("\n%-25s $  %" + grossPayStringLength + ".2f", "Gross Pay:", grossPay);
			System.out.printf("\n%-25s $  %" + grossPayStringLength + ".2f", "Federal withholding: ", federalTax);
			System.out.printf("\n%-25s $  %" + grossPayStringLength + ".2f\n", "State withholding: ", stateTax);

			String lineChar = "-";
			System.out.print(lineChar.repeat(grossPayStringLength + 25 + 4));
			System.out.printf("\n%-25s $  %" + grossPayStringLength + ".2f \n\n", "Net pay: ", netPay);
			
			// Asks the user if they want to try again, "n" will exit console.
			while ((goAgain != "y") && (goAgain != "n")) {
				System.out.print("Would you like to enter a new payroll (y/n)? ");
				goAgain = scanner.next().toLowerCase();
				if ((!goAgain.equals("y")) && (!goAgain.equals("n"))) {
					System.out.println("\nPlease choose either y or n.\n");
				} else {
					System.out.print("\n\n");
					break;
				}
			}
		//This lets my program be in a loop, if the user chooses "y", it will run again, "n" will display the bottom message.
		} while (goAgain.equalsIgnoreCase("y"));

		System.out.println("Thank you for choosing this Payroll Calculator, have a good day!");
		scanner.close();

	}
}
