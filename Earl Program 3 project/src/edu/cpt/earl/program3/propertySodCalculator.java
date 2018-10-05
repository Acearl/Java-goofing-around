package edu.cpt.earl.program3;
import java.util.Scanner;

/** Property Sod Calculation: Assignment3
 * Author: Andrew Earl
 * Course: CPT 167
 * Purpose: Calculate the uncovered area of a property with user input for sod
 * Create Date: 9/13/2018
 */

public class propertySodCalculator {
	
	public static void main(String[] args) {
		
		//declare scanner object
		Scanner input = new Scanner(System.in);
		
		//final variables
		final double WIDTH_RESTRICTION = .75;
		final double LENGTH_RESTRICTION = .50;
		final double WATER_DEPTH = 6.00;
		final String KENTUCKY_BLUEGRASS_NAME = "Bluegrass";
		final String SC_RYE_NAME = "Rye";
		final double KENTUCKY_BLUEGRASS_COST = 1.47;
		final double SC_RYE_COST = 0.57;
		final String UNIT_A = "Unit A3.1";
		final String UNIT_B = "Unit B8.0";
		final String UNIT_C = "Unit C15";
		final String UNIT_D = "Unit D25";
		final String UNIT_E = "Unit E25+";
		//final int UNIT_A_CAPACITY = 3100; commented out because it is unused but still there if a programmer needs it.
		final int UNIT_B_CAPACITY = 8000;
		final int UNIT_C_CAPACITY = 15000;
		final int UNIT_D_CAPACITY = 25000;
		final int UNIT_E_CAPACITY = 25001;
		
		//modular variables
		String userName = "";
		double propertyWidth = 0.0;
		double propertyLength = 0.0;
		double propertySquareFootage = 0.0;
		double houseWidth = 0.0;
		double houseLength = 0.0;
		double houseSquareFootage = 0.0;
		double poolWidth = 0.0;
		double poolLength = 0.0;
		double poolSquareFootage = 0.0;
		double coveredSquareFootage = 0.0;
		double uncoveredSquareFootage = 0.0;
		double sodCost = 0.0;
		double sodPrice = 0.0;
		double waterVolume = 0.0;
		String sodName = "";
		String heaterUnit = "";
		char sodType = ' ';
		
		//User input and welcome banner
		
		System.out.println("------------------------------------------------------------");
		System.out.println("\tHello and welcome to the local county property");
		System.out.println("calculator. This program is designed to help you measure");
		System.out.println("the footprint of your property to determine your price for");
		System.out.println("the madatory sod purchasing law currently in effect. As");
		System.out.println("well as the heater required for the pool.");
		System.out.println("------------------------------------------------------------\n");
		
		System.out.print("*Please note this program assumes you have the maximum size for\nbuidlings on the property.*");

		System.out.print("\n\n\tTo begin, what is your name?: ");
		userName = input.nextLine();
		
		System.out.print("\nWhat is the width of your entire property in feet?: ");
		propertyWidth = input.nextDouble();
		
		System.out.print("\nWhat is the length of your entire property in feet?: ");
		propertyLength = input.nextDouble();
		
		System.out.print("\nWhich type of sod will you be purchasing? |A| or |B|: ");
		System.out.printf("%-3s%-15s","\n|A|",KENTUCKY_BLUEGRASS_NAME);
		System.out.printf("%-3s%-15s","\n|B|",SC_RYE_NAME);
		System.out.print("\n:");
		sodType = input.next().charAt(0);
		
		//calculations
		sodType = Character.toLowerCase(sodType);
		
		propertySquareFootage = propertyWidth * propertyLength;
		
		houseWidth = propertyWidth * WIDTH_RESTRICTION;
		
		houseLength = propertyLength * LENGTH_RESTRICTION;
		
		houseSquareFootage = houseWidth * houseLength;
		
		poolWidth = houseWidth * WIDTH_RESTRICTION;
		
		poolLength = houseLength * LENGTH_RESTRICTION;
		
		poolSquareFootage = poolWidth * poolLength;
		
		coveredSquareFootage = houseSquareFootage + poolSquareFootage;
		
		uncoveredSquareFootage = propertySquareFootage - coveredSquareFootage;
		
		if (sodType == 'a') {
			sodName = KENTUCKY_BLUEGRASS_NAME;
			sodPrice = KENTUCKY_BLUEGRASS_COST;
			
		}else {
				sodName = SC_RYE_NAME;
				sodPrice = SC_RYE_COST;
		}
		
		sodCost = sodPrice * uncoveredSquareFootage;
				
		waterVolume = poolSquareFootage * WATER_DEPTH;
		
		if (waterVolume >= UNIT_E_CAPACITY) {
			heaterUnit = UNIT_E;
		}
		else if (waterVolume >= UNIT_D_CAPACITY) {
			heaterUnit = UNIT_D;
		}
		else if (waterVolume >= UNIT_C_CAPACITY) {
			heaterUnit = UNIT_C;
		}
		else if (waterVolume >= UNIT_B_CAPACITY) {
			heaterUnit = UNIT_B;
		}
		else {
			heaterUnit = UNIT_A;
		}
		
		System.out.println("------------------------------------------------------------\n");
		
		System.out.println("The following is a summery of the land border data.\n");
		
		System.out.printf("%-15s%12s%10s%12s%10s","Name","Width","Units ","Length","Units");
		System.out.printf("%-15s%12.1f%10s%12.1f%10s","\nProperty",propertyWidth,"ft by",propertyLength,"ft");
		System.out.printf("%-15s%12.1f%10s%12.1f%10s","\nHosue",houseWidth,"ft by",houseLength,"ft");
		System.out.printf("%-15s%12.1f%10s%12.1f%10s","\nPool",poolWidth,"ft by",poolLength,"ft");
		
		System.out.println("\n------------------------------------------------------------\n");
		
		System.out.println("The following is a summery of land area data.\n");
		
		System.out.printf("%-15s%12s%10s","Name","Amount","Units");
		System.out.printf("%-15s%12.1f%10s","\nProperty",propertySquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nHouse",houseSquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nPool",poolSquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nCovered Area",coveredSquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nUncovered Area",uncoveredSquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nWater Volume",waterVolume,"ft^3");
		
		System.out.println("\n------------------------------------------------------------\n");
		
		System.out.println("The following is a summery of pool and sod area data\n");
		
		System.out.printf("%-15s%-12s%10s","Heater reqired","",heaterUnit);
		System.out.printf("%-15s%-12s%10s","\nSod Chosen","",sodName);
		System.out.printf("%-15s%-12s%10.2f","\nSod Price","$ per in^2",sodPrice);
		
		System.out.println("\n------------------------------------------------------------\n");
		
		System.out.println("The total cost for the purchase of sod for your land");
		System.out.println("*Heater price subject to change and therefore is not included*\n");
		
		System.out.printf("%-15s%12s%10.2f","Total cost","$",sodCost);
		
		System.out.println("\n------------------------------------------------------------\n");
		
		System.out.println("Thank you for your input " + userName + ".");
		System.out.println("Good luck and we hope to see you again!");
		
		//Close scanner
		input.close();
	}
}
