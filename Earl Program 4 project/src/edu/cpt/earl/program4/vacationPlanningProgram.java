package edu.cpt.earl.program4;
import java.util.Scanner;

/** Property Sod Calculation: Assignment3
 * Author: Andrew Earl
 * Course: CPT 167
 * Purpose: Calculate cost for travel destination and upgrades on travel
 * Create Date: 9/28/2018
 */

public class vacationPlanningProgram {
	
	public static void main(String[] args) {
		
		//declare scanner
		
		Scanner input = new Scanner(System.in);
		
		//constants
		
		final String DESTINATION_ROME_ITALY = "Rome, Italy";
		final String DESTINATION_LONDON_ENGLAND = "London, England";
		final String DESTINATION_KEY_WEST_FLORDIA = "Key West, Flordia, USA";
		final String TRANSPORT_AIRPLANE = "Airplane";
		final String TRANSPORT_SHIP = "Passenger Ship";
		final String FIRST_CLASS_ACCOM = "First Class Accommodations";
		final String FIRST_CLASS_LODGING = "First Class Lodging";
		final String GUIDED_TOUR = "Guided Tour";
		final String ALL_UPGRADED_SERVICES = "All upgrade Services";
		final String NO_UPGRADED_SERVICES = "No upgrades";
		final double FIRST_CLASS_ACCOM_COST = 75.0;
		final double FIRST_CLASS_LODGING_COST = 125.0;
		final double AIRPLANE_COST = 500.0;
		final double SHIP_COST = 250.0;
		final double GUIDED_TOUR_COST = 50.0;
		final double ALL_UPGRADED_SERVICES_COST = 200.0;
		final double NO_UPGRADED_SERVICES_COST = 0.0;
		final double DEFAULT_LODGING_FEE = 500.0;

		
		String userName = "";
		String modeOfTransport = "";
		String destination = "";
		String upgradeName = "";
		char firstMenuAnswer = ' ';
		char secondMenuAnswer = ' ';
		char thirdMenuAnswer = ' ';
		double totalTripCost = 0.0;
		double modeOfTransportCost = 0.0;
		double upgradeValue = 0.0;
		
		
		System.out.println("------------------------------------------------------------");
		System.out.println("\tHello and Welcome to the Vacation Calulation Machine!\n");
		System.out.println("This program is designed to assist you with finding");
		System.out.println("the cost of a Vacation to several locations.");
		System.out.println("------------------------------------------------------------\n");
		System.out.println("To begin, What is your name? ");
		
		System.out.println("");
		System.out.print(": ");
		
		userName = input.nextLine();
		
		System.out.println("----------------------------New Menu------------------------\n");
		System.out.println("Travel Destination Selection:\n");
		System.out.printf("%-3s%30s%3s%6.2f","\n|A|", DESTINATION_ROME_ITALY,"  $",DEFAULT_LODGING_FEE);
		System.out.printf("%-3s%30s%3s%6.2f","\n|B|", DESTINATION_LONDON_ENGLAND,"  $",DEFAULT_LODGING_FEE);
		System.out.printf("%-3s%30s%3s%6.2f","\n|C|", DESTINATION_KEY_WEST_FLORDIA,"  $",DEFAULT_LODGING_FEE);
		
		System.out.println("");
		System.out.println("");
		System.out.print(": ");
		
		firstMenuAnswer = input.nextLine().charAt(0);
		
		firstMenuAnswer = Character.toLowerCase(firstMenuAnswer);
		
		while (firstMenuAnswer != 'a' && firstMenuAnswer != 'b' && firstMenuAnswer != 'c') {
			
			System.out.println("------------------------------------------------------------\n");
			System.out.println("That input is invalid. Try again.\n");
			System.out.println("Travel Destination Selection:\n");
			System.out.printf("%-3s%30s%3s%6.2f","\n|A|", DESTINATION_ROME_ITALY,"  $",DEFAULT_LODGING_FEE);
			System.out.printf("%-3s%30s%3s%6.2f","\n|B|", DESTINATION_LONDON_ENGLAND,"  $",DEFAULT_LODGING_FEE);
			System.out.printf("%-3s%30s%3s%6.2f","\n|C|", DESTINATION_KEY_WEST_FLORDIA,"  $",DEFAULT_LODGING_FEE);
			
			System.out.println("");
			System.out.println("");
			System.out.print(": ");
			
			firstMenuAnswer = input.nextLine().charAt(0);
			
			firstMenuAnswer = Character.toLowerCase(firstMenuAnswer);
			
			
		}
		
		System.out.println("----------------------------New Menu------------------------\n");
		System.out.println("Travel Method Selection:\n");
		System.out.printf("%-3s%30s%3s%6.2f","\n|A|", TRANSPORT_AIRPLANE,"  $",AIRPLANE_COST);
		System.out.printf("%-3s%30s%3s%6.2f","\n|B|", TRANSPORT_SHIP,"  $",SHIP_COST);
		
		System.out.println("");
		System.out.println("");
		System.out.print(": ");
		
		secondMenuAnswer = input.nextLine().charAt(0);
		
		secondMenuAnswer = Character.toLowerCase(secondMenuAnswer);
		
		
		while (secondMenuAnswer != 'a' && secondMenuAnswer != 'b') {
			
			System.out.println("------------------------------------------------------------\n");
			System.out.println("That input is invalid. Try again.\n");
			System.out.println("Travel Method Selection:\n");
			System.out.printf("%-3s%30s%3s%6.2f","\n|A|", TRANSPORT_AIRPLANE,"  $",AIRPLANE_COST);
			System.out.printf("%-3s%30s%3s%6.2f","\n|B|", TRANSPORT_SHIP,"  $",SHIP_COST);
			
			System.out.println("");
			System.out.println("");
			System.out.print(": ");
			
			secondMenuAnswer = input.nextLine().charAt(0);
			
			secondMenuAnswer = Character.toLowerCase(secondMenuAnswer);
			
			
			
		}
		
		System.out.println("----------------------------New Menu------------------------\n");
		System.out.println("Upgrade Selection:\n");
		System.out.printf("%-3s%30s%3s%6.2f","\n|A|", FIRST_CLASS_ACCOM,"  $",FIRST_CLASS_ACCOM_COST);
		System.out.printf("%-3s%30s%3s%6.2f","\n|B|", FIRST_CLASS_LODGING,"  $",FIRST_CLASS_LODGING_COST);
		System.out.printf("%-3s%30s%3s%6.2f","\n|C|", GUIDED_TOUR,"  $",GUIDED_TOUR_COST);
		System.out.printf("%-3s%30s%3s%6.2f","\n|D|", ALL_UPGRADED_SERVICES,"  $",ALL_UPGRADED_SERVICES_COST);
		System.out.printf("%-3s%30s%3s%6.2f","\n|E|", NO_UPGRADED_SERVICES,"  $",NO_UPGRADED_SERVICES_COST);
		
		System.out.println("");
		System.out.println("");
		System.out.print(": ");
		
		thirdMenuAnswer = input.nextLine().charAt(0);
		
		thirdMenuAnswer = Character.toLowerCase(thirdMenuAnswer);
		
		while (thirdMenuAnswer != 'a' && thirdMenuAnswer != 'b' && thirdMenuAnswer != 'c' && thirdMenuAnswer != 'd' && thirdMenuAnswer != 'e') {
			
			System.out.println("------------------------------------------------------------\n");
			System.out.println("That input is invalid. Try again.\n");
			System.out.println("Upgrade Selection:\n");
			System.out.printf("%-3s%30s%3s%6.2f","\n|A|", FIRST_CLASS_ACCOM,"  $",FIRST_CLASS_ACCOM_COST);
			System.out.printf("%-3s%30s%3s%6.2f","\n|B|", FIRST_CLASS_LODGING,"  $",FIRST_CLASS_LODGING_COST);
			System.out.printf("%-3s%30s%3s%6.2f","\n|C|", GUIDED_TOUR,"  $",GUIDED_TOUR_COST);
			System.out.printf("%-3s%30s%3s%6.2f","\n|D|", ALL_UPGRADED_SERVICES,"  $",ALL_UPGRADED_SERVICES_COST);
			System.out.printf("%-3s%30s%3s%6.2f","\n|E|", NO_UPGRADED_SERVICES,"  $",NO_UPGRADED_SERVICES_COST);
			
			System.out.println("");
			System.out.println("");
			System.out.print(": ");
			
			thirdMenuAnswer = input.nextLine().charAt(0);
			
			thirdMenuAnswer = Character.toLowerCase(thirdMenuAnswer);
		}
		
		
		//Decision trees
		
		if (firstMenuAnswer == 'a') {
			destination = DESTINATION_ROME_ITALY;
		}
		else if(firstMenuAnswer == 'b') {
			destination = DESTINATION_LONDON_ENGLAND;
		}
		else {
			destination = DESTINATION_KEY_WEST_FLORDIA;
		}
		
		
		
		if (secondMenuAnswer == 'a') {
			modeOfTransport = TRANSPORT_AIRPLANE;
			modeOfTransportCost = AIRPLANE_COST;
		}
		else {
			modeOfTransport = TRANSPORT_SHIP;
			modeOfTransportCost = SHIP_COST;
		}
		
		
		
		if (thirdMenuAnswer == 'a') {
			upgradeValue = FIRST_CLASS_ACCOM_COST;
			upgradeName = FIRST_CLASS_ACCOM;
		}
		else if(thirdMenuAnswer == 'b') {
			upgradeValue = FIRST_CLASS_LODGING_COST;
			upgradeName = FIRST_CLASS_LODGING;
		}
		else if(thirdMenuAnswer == 'c') {
			upgradeValue = GUIDED_TOUR_COST;
			upgradeName = GUIDED_TOUR;
		}
		else if(thirdMenuAnswer == 'd') {
			upgradeValue = ALL_UPGRADED_SERVICES_COST;
			upgradeName = ALL_UPGRADED_SERVICES;
		}
		else {
			upgradeValue = NO_UPGRADED_SERVICES_COST;
			upgradeName = NO_UPGRADED_SERVICES;
		}
		
		
		//Calculations
		
		totalTripCost = DEFAULT_LODGING_FEE + upgradeValue + modeOfTransportCost;
		
		//Display output
		System.out.println("------------------------------------------------------------");
		System.out.println("-----------------------Results-Menu-------------------------");
		System.out.println("------------------------------------------------------------\n");
		
		System.out.println("The information on your Vacation," + userName + ".\n");
		
		System.out.printf("%-20s%20s%3s%10s","\nLabel", "Name","  $", "Dollars");
		System.out.println("\n************************************************************");
		System.out.printf("%-20s%20s%3s%8.2f","\nDestination", destination,"  $", DEFAULT_LODGING_FEE);
		System.out.printf("%-20s%20s%3s%8.2f","\nTransportation", modeOfTransport,"  $", modeOfTransportCost);
		System.out.printf("%-20s%20s%3s%8.2f","\nName of Upgrade(s)",upgradeName,"  $", upgradeValue);
		System.out.println("\n************************************************************");
		System.out.printf("%-20s%3s%6.2f","\n\tTotal Trip Cost","  $", totalTripCost);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Thank you for your time and have fun on your trip.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}