package edu.cpt167.earl.program1;
import java.util.Scanner;

/** Property Area Calculation: Assignment1.java
 * Author: Andrew Earl
 * Course: CPT 167
 * Purpose: Calculate the uncovered area of a property with user input
 * Create Date: 8/29/2018
 */

public class propertyCalculator {

	public static void main(String[] args) {
		
		//declare scanner object
		Scanner input = new Scanner(System.in);
		
		//Declare variables
		String userName = "";
		Double propertyLength = 0.0;
		Double propertyWidth = 0.0;
		Double houseLength = 0.0;
		Double houseWidth = 0.0;
		Double poolLength = 0.0;
		Double poolWidth = 0.0;
		Double propertyArea = 0.0;
		Double houseArea = 0.0;
		Double poolArea = 0.0;
		Double uncoveredArea = 0.0;
		
		//Welcome Banner
		System.out.println("Welcome to the land plot calculator!");
		System.out.println("------------------------------------------------------------");
		System.out.println("	The Purpose of this program is to calculate the square");
		System.out.println("feet of certian objects on a property. In this case you will");
		System.out.println("be asked to input dimensions for the whole property, the house");
		System.out.println("on the property, and the pool on the property.");
		System.out.println("");
		System.out.println("Written by: Andrew Earl");
		System.out.println("------------------------------------------------------------\n");
		
		//User data input
		//User name
		System.out.println("Hello, What is your name?\n*Please Enter name below*");
		userName = input.nextLine();
		
		System.out.println("Ok " + userName + ", I am going to ask you a series of questions\nabout your property.\n");
		
		System.out.println("What is the Length of the property in feet?");
		propertyLength = input.nextDouble();
		
		System.out.println("What is the Width of the property in feet?");
		propertyWidth = input.nextDouble();
		
		System.out.println("What is the Length of the house in feet?");
		houseLength = input.nextDouble();
		
		System.out.println("What is the Width of the house in feet?");
		houseWidth = input.nextDouble();
		
		System.out.println("What is the Length of the pool in feet?");
		poolLength = input.nextDouble();
		
		System.out.println("What is the Width of the pool in feet?");
		poolWidth = input.nextDouble();
		
		System.out.println("Calculating... Please Wait\n");
		
		//Calculations
		
		propertyArea = propertyLength * propertyWidth;
				
		houseArea = houseLength * houseWidth;
		
		poolArea = poolLength * poolWidth;
		
		uncoveredArea = propertyArea - (houseArea + poolArea);
		
		//Displaying Results
		System.out.println("------------------------------------------------------------");
		System.out.println("The dimensions of the property are " + propertyLength + " feet by " + propertyWidth + " feet.");
		System.out.println("With an Area of " + propertyArea + " feet squared.");
		System.out.println("------------------------------------------------------------");
		System.out.println("The dimensions of the house are " + houseLength + " feet by " + houseWidth + " feet.");
		System.out.println("With an Area of " + houseArea + " feet squared.");
		System.out.println("------------------------------------------------------------");
		System.out.println("The dimensions of the pool are " + poolLength + " feet by " + poolWidth + " feet.");
		System.out.println("With an Area of " + poolArea + " feet squared.");
		System.out.println("------------------------------------------------------------");
		System.out.println("And finally the uncovered area on the property is " + uncoveredArea + " Feet Squared.");
		System.out.println("------------------------------------------------------------");
		
		//Farewell message
		System.out.println(userName +", Thank you for your time and we hope to see you again soon :)");
		
		//Close scanner object
		input.close();
	}

}
