package edu.cpt167.earl.program2;
import java.util.Scanner;

/** Property Area Calculation: Assignment2.java
 * Author: Andrew Earl
 * Course: CPT 167
 * Purpose: Calculate the uncovered area of a property with user input
 * Create Date: 9/7/2018
 */

public class propertyCalculator {

	public static void main(String[] args) {
		
		//declare scanner object
		Scanner input = new Scanner(System.in);
		
		//declare variables
		final double WIDTH_RESTRICTION = .75;
		final double LENGTH_RESTRICTION = .5;
		final double SOD_PRICE = 1.39;
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
		
		//User input
		
		System.out.println("------------------------------------------------------------");
		System.out.println("\tHello and welcome to the local county property");
		System.out.println("calculator. This program is designed to help you measure");
		System.out.println("the footprint of your property to determine your price for");
		System.out.println("the madatory sod purchasing law currently in effect.");
		System.out.println("------------------------------------------------------------\n");
		
		System.out.print("*Please note this program assumes you have the maximum size for\nbuidlings on the property.*");
		
		System.out.print("\n\n\tTo begin, what is your name?: ");
		userName = input.nextLine();
		
		System.out.print("\nWhat is the width of your entire property in feet?: ");
		propertyWidth = input.nextDouble();
		
		System.out.print("\nWhat is the length of your entire property in feet?: ");
		propertyLength = input.nextDouble();
		
		
		System.out.println("Processing... Please wait");
		
		//Calculations
		propertySquareFootage = propertyWidth * propertyLength;
				
		houseWidth = propertyWidth * WIDTH_RESTRICTION;
		
		houseLength = propertyLength * LENGTH_RESTRICTION;
		
		houseSquareFootage = houseWidth * houseLength;
		
		poolWidth = houseWidth * WIDTH_RESTRICTION;
		
		poolLength = houseLength * LENGTH_RESTRICTION;
		
		poolSquareFootage = poolWidth * poolLength;
		
		coveredSquareFootage = houseSquareFootage + poolSquareFootage;
		
		uncoveredSquareFootage = propertySquareFootage - coveredSquareFootage;
		
		sodCost = uncoveredSquareFootage * SOD_PRICE;
		
		//display results
		
		
		System.out.println("------------------------------------------------------------\n");
		
		System.out.println("The following is a summery of the land border data.\n");
		
		System.out.printf("%-15s%12s%10s%12s%10s","Name","Width","Units ","Length","Units");
		System.out.printf("%-15s%12.1f%10s%12.1f%10s","\nProperty",propertyWidth,"ft by",propertyLength,"ft");
		System.out.printf("%-15s%12.1f%10s%12.1f%10s","\nHosue",houseWidth,"ft by",houseLength,"ft");
		System.out.printf("%-15s%12.1f%10s%12.1f%10s","\nPool",poolWidth,"ft by",poolLength,"ft");
		
		System.out.println("\n------------------------------------------------------------\n");
		
		System.out.println("The following is a summery land area data\n");
		
		System.out.printf("%-15s%12s%10s","Name","Amount","Units");
		System.out.printf("%-15s%12.1f%10s","\nProperty",propertySquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nHouse",houseSquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nPool",poolSquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nCovered Area",coveredSquareFootage,"ft^2");
		System.out.printf("%-15s%12.1f%10s","\nUncovered Area",uncoveredSquareFootage,"ft^2");
		
		System.out.println("\n------------------------------------------------------------\n");
		
		System.out.println("The total cost for the purchase of sod for your land\n");
		
		System.out.printf("%-15s%12s%10.2f","\nUncovered Area","$",sodCost);
		
		System.out.println("\n------------------------------------------------------------\n");
		
		System.out.println("Thank you for your input " + userName + "!");
		System.out.println("Good luck and we hope to see you again!");
		
		//Close scanner
		input.close();
	}

}