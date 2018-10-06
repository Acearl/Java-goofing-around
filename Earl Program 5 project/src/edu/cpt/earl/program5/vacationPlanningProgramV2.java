package edu.cpt.earl.program5;
import java.util.Scanner;

/** Vacation calculator: Program5
 * Author: Andrew Earl
 * Course: CPT 167
 * Purpose: Calculate cost for travel destination and upgrades on travel
 * Create Date: 10/3/2018
 */

public class vacationPlanningProgramV2 {

	public static void main(String[] args) {
		
		//declare scanner
		
		Scanner input = new Scanner(System.in);
		
		//declare constants
		
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
		
		char destinationSlection = ' ';
		char transportationSlection = ' ';
		char upgradeSelection = ' ';

		//The Cost of any Destination is $500 dollars, which is the DEFAULT_LODGING_FEE
		
		String userName = "";
		String destinationName = "";
		String transportationName = "";
		double transportationCost = 0.0;
		String upgradeName = "";
		double upgradeCost = 0.0;
		double totalTripCost = 0.0;
		double completeTripCost = 0.0;
		
		int counterDays = 0;
		
		//Start of method programs
		welcomeBanner();
		
		userName = askUserName(input);
		
		destinationSlection = validateMainMenuSelection(input, DESTINATION_ROME_ITALY, DESTINATION_LONDON_ENGLAND, DESTINATION_KEY_WEST_FLORDIA, DEFAULT_LODGING_FEE);
		
		while (destinationSlection != 'q') {
			
			transportationSlection = validateTransportationMenuSelection(input, TRANSPORT_AIRPLANE, TRANSPORT_SHIP, AIRPLANE_COST, SHIP_COST);
			
			upgradeSelection = validateUpgradeMenuSelection(input, FIRST_CLASS_ACCOM, FIRST_CLASS_LODGING, GUIDED_TOUR, ALL_UPGRADED_SERVICES, NO_UPGRADED_SERVICES, FIRST_CLASS_ACCOM_COST, FIRST_CLASS_LODGING_COST, GUIDED_TOUR_COST, ALL_UPGRADED_SERVICES_COST, NO_UPGRADED_SERVICES_COST);
					
			destinationName = destinationDecider(destinationSlection, DESTINATION_ROME_ITALY, DESTINATION_LONDON_ENGLAND, DESTINATION_KEY_WEST_FLORDIA);
			
			transportationName = transportationDecider(transportationSlection, TRANSPORT_AIRPLANE, TRANSPORT_SHIP);
			
			transportationCost = transportationCostDecider(transportationSlection, AIRPLANE_COST, SHIP_COST);
			
			upgradeName = upgradeDecider(upgradeSelection, FIRST_CLASS_ACCOM, FIRST_CLASS_LODGING, GUIDED_TOUR, ALL_UPGRADED_SERVICES, NO_UPGRADED_SERVICES);
			
			upgradeCost = upgradeCostDecider(upgradeSelection, FIRST_CLASS_ACCOM_COST, FIRST_CLASS_LODGING_COST, GUIDED_TOUR_COST, ALL_UPGRADED_SERVICES_COST, NO_UPGRADED_SERVICES_COST);
			
			totalTripCost = totalTripCostCalculation(DEFAULT_LODGING_FEE, transportationCost, upgradeCost);
			
			totalTripCostReceipt(userName, destinationName, transportationName, upgradeName, transportationCost, DEFAULT_LODGING_FEE, upgradeCost, totalTripCost);
				
			completeTripCost = completeTripCost + totalTripCost;
			
			counterDays++;
			
			destinationSlection = validateMainMenuSelection(input, DESTINATION_ROME_ITALY, DESTINATION_LONDON_ENGLAND, DESTINATION_KEY_WEST_FLORDIA, DEFAULT_LODGING_FEE);
		
		}//end of main while loop
		
		farewellBanner(counterDays, completeTripCost);
		
	}//end of main
	
	public static void welcomeBanner() {
		
		System.out.println("------------------------------------------------------------");
		System.out.println("    Hello and Welcome to the Vacation Calulation Machine!\n");
		System.out.println("This program is designed to assist you with finding");
		System.out.println("the cost of a Vacation to several locations.");
		System.out.println("------------------------------------------------------------\n");
		
	}//end of welcomeBanner
	
	public static String askUserName(Scanner borrowedInput) {
		
		String userName = "";
		
		System.out.println("To begin, What is your name? ");
		
		System.out.println("");
		System.out.print(": ");
		
		userName = borrowedInput.nextLine();
		
		return userName;
		
	}//end askUserName
	
	public static char validateMainMenuSelection(Scanner borrowedInput, String DESTINATION_ROME_ITALY, String DESTINATION_LONDON_ENGLAND, String DESTINATION_KEY_WEST_FLORDIA, double DEFAULT_LODGING_FEE) {
	
		char localMenuAnswer = ' ';
		
		System.out.println("----------------------------New Menu------------------------\n");
		System.out.println("Travel Destination Selection:\n");
		System.out.printf("%-3s%30s%3s%6.2f","\n|A|", DESTINATION_ROME_ITALY,"  $",DEFAULT_LODGING_FEE);
		System.out.printf("%-3s%30s%3s%6.2f","\n|B|", DESTINATION_LONDON_ENGLAND,"  $",DEFAULT_LODGING_FEE);
		System.out.printf("%-3s%30s%3s%6.2f","\n|C|", DESTINATION_KEY_WEST_FLORDIA,"  $",DEFAULT_LODGING_FEE);
		System.out.printf("%-3s%30s%3s","\n|Q|", " ","Quit");

		System.out.println("\n\n(Type 'Q' to exit the program and/or get a final report)");

		System.out.println("");
		System.out.print(": ");
		
		localMenuAnswer = borrowedInput.nextLine().charAt(0);
		
		localMenuAnswer = Character.toLowerCase(localMenuAnswer);
		
		while (localMenuAnswer != 'a' && localMenuAnswer != 'b' && localMenuAnswer != 'c' && localMenuAnswer != 'q') {
			
			System.out.println("------------------------------------------------------------\n");
			System.out.println("That input is invalid. Try again.\n");
			System.out.println("Travel Destination Selection:\n");
			System.out.printf("%-3s%30s%3s%6.2f","\n|A|", DESTINATION_ROME_ITALY,"  $",DEFAULT_LODGING_FEE);
			System.out.printf("%-3s%30s%3s%6.2f","\n|B|", DESTINATION_LONDON_ENGLAND,"  $",DEFAULT_LODGING_FEE);
			System.out.printf("%-3s%30s%3s%6.2f","\n|C|", DESTINATION_KEY_WEST_FLORDIA,"  $",DEFAULT_LODGING_FEE);
			
			System.out.println("");
			System.out.print(": ");
			
			localMenuAnswer = borrowedInput.nextLine().charAt(0);
			
			localMenuAnswer = Character.toLowerCase(localMenuAnswer);
			
		}//end of validateMainMenuSelection while loop
	
		return localMenuAnswer;
	
	}//end of validateMainMenuSelection
	
	public static char validateTransportationMenuSelection(Scanner borrowedInput, String TRANSPORT_AIRPLANE, String TRANSPORT_SHIP, double AIRPLANE_COST, double SHIP_COST) {
		
		char localMenuAnswer = ' ';
		
		System.out.println("----------------------------New Menu------------------------\n");
		System.out.println("Travel Method Selection:\n");
		System.out.printf("%-3s%30s%3s%6.2f","\n|A|", TRANSPORT_AIRPLANE,"  $",AIRPLANE_COST);
		System.out.printf("%-3s%30s%3s%6.2f","\n|B|", TRANSPORT_SHIP,"  $",SHIP_COST);
		
		System.out.println("");
		System.out.println("");
		System.out.print(": ");
		
		localMenuAnswer = borrowedInput.nextLine().charAt(0);
		
		localMenuAnswer = Character.toLowerCase(localMenuAnswer);
		
		
		while (localMenuAnswer != 'a' && localMenuAnswer != 'b') {
			
			System.out.println("------------------------------------------------------------\n");
			System.out.println("That input is invalid. Try again.\n");
			System.out.println("Travel Method Selection:\n");
			System.out.printf("%-3s%30s%3s%6.2f","\n|A|", TRANSPORT_AIRPLANE,"  $",AIRPLANE_COST);
			System.out.printf("%-3s%30s%3s%6.2f","\n|B|", TRANSPORT_SHIP,"  $",SHIP_COST);
			
			System.out.println("");
			System.out.println("");
			System.out.print(": ");
			
			localMenuAnswer = borrowedInput.nextLine().charAt(0);
			
			localMenuAnswer = Character.toLowerCase(localMenuAnswer);
			
		}//end of validateTransportationMenuSelection while loop
		
		return localMenuAnswer;
		
	}//end of validateTransportationMenuSelection
	
	public static char validateUpgradeMenuSelection(Scanner borrowedInput, String FIRST_CLASS_ACCOM, String FIRST_CLASS_LODGING, String GUIDED_TOUR, String ALL_UPGRADED_SERVICES, String NO_UPGRADED_SERVICES, double FIRST_CLASS_ACCOM_COST, double FIRST_CLASS_LODGING_COST, double GUIDED_TOUR_COST, double ALL_UPGRADED_SERVICES_COST, double NO_UPGRADED_SERVICES_COST) {
		
		char localMenuAnswer = ' ';
		
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
		
		localMenuAnswer = borrowedInput.nextLine().charAt(0);
		
		localMenuAnswer = Character.toLowerCase(localMenuAnswer);
		
		while (localMenuAnswer != 'a' && localMenuAnswer != 'b' && localMenuAnswer != 'c' && localMenuAnswer != 'd' && localMenuAnswer != 'e') {
			
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
			
			localMenuAnswer = borrowedInput.nextLine().charAt(0);
			
			localMenuAnswer = Character.toLowerCase(localMenuAnswer);
			
		}//end of validateUpdateMenuSelection while loop
		
		return localMenuAnswer;
		
	}//end of validateUpdateMenuSelection
	
	public static String destinationDecider(char localMenuAnswer, String DESTINATION_ROME_ITALY, String DESTINATION_LONDON_ENGLAND, String DESTINATION_KEY_WEST_FLORDIA) {
		
		String destination = "";
		
		if (localMenuAnswer == 'a') {
			destination = DESTINATION_ROME_ITALY;
		}
		else if(localMenuAnswer == 'b') {
			destination = DESTINATION_LONDON_ENGLAND;
		}
		else {
			destination = DESTINATION_KEY_WEST_FLORDIA;
		}
		
		return destination;
				
	}//end of destinationDecider
	
	public static String transportationDecider(char localMenuAnswer, String TRANSPORT_AIRPLANE, String TRANSPORT_SHIP) {
			
		String modeOfTransport = "";
		
		if (localMenuAnswer == 'a') {
			
			modeOfTransport = TRANSPORT_AIRPLANE;
			
		}
		else {
			
			modeOfTransport = TRANSPORT_SHIP;
			
		}
		
		return modeOfTransport;
		
	}//end of transportationDecider
	
	public static double transportationCostDecider(char localMenuAnswer, double AIRPLANE_COST, double SHIP_COST) {
		
		double modeOfTransportCost = 0.0;
		
		if (localMenuAnswer == 'a') {
			
			modeOfTransportCost = AIRPLANE_COST;
		}
		else {
			
			modeOfTransportCost = SHIP_COST;
		}
		
		return modeOfTransportCost;
		
	}//end of transportationCostDecider
	
	public static String upgradeDecider(char localMenuAnswer, String FIRST_CLASS_ACCOM, String FIRST_CLASS_LODGING, String GUIDED_TOUR, String ALL_UPGRADED_SERVICES, String NO_UPGRADED_SERVICES) {
		
		String upgradeName = "";
		
		if (localMenuAnswer == 'a') {
			
			upgradeName = FIRST_CLASS_ACCOM;
		}
		else if(localMenuAnswer == 'b') {
			
			upgradeName = FIRST_CLASS_LODGING;
		}
		else if(localMenuAnswer == 'c') {
			
			upgradeName = GUIDED_TOUR;
		}
		else if(localMenuAnswer == 'd') {
			
			upgradeName = ALL_UPGRADED_SERVICES;
		}
		else {
			
			upgradeName = NO_UPGRADED_SERVICES;
		}
		
		return upgradeName;
		
	}//end of upgradeDecider

	public static double upgradeCostDecider(char localMenuAnswer, double FIRST_CLASS_ACCOM_COST, double FIRST_CLASS_LODGING_COST, double GUIDED_TOUR_COST, double ALL_UPGRADED_SERVICES_COST, double NO_UPGRADED_SERVICES_COST) {
		
		double upgradeValue;
		
		if (localMenuAnswer == 'a') {
			
			upgradeValue = FIRST_CLASS_ACCOM_COST;
			
		}
		else if(localMenuAnswer == 'b') {
			
			upgradeValue = FIRST_CLASS_LODGING_COST;
			
		}
		else if(localMenuAnswer == 'c') {
			
			upgradeValue = GUIDED_TOUR_COST;
			
		}
		else if(localMenuAnswer == 'd') {
			
			upgradeValue = ALL_UPGRADED_SERVICES_COST;
			
		}
		else {
			
			upgradeValue = NO_UPGRADED_SERVICES_COST;
			
		}
		
		return upgradeValue;
		
	}//end of upgradeCostDecider

	public static double totalTripCostCalculation(double DEFAULT_LODGING_FEE, double transportationCost, double upgradeCost) {
		
		double totalCost = 0.0;
		
		totalCost = DEFAULT_LODGING_FEE + transportationCost + upgradeCost;
		
		return totalCost;
	}
	
	public static void totalTripCostReceipt(String userName, String destinationName, String transportationName, String upgradeName, double DEFAULT_LODGING_FEE, double upgradeCost, double transportationCost, double totalTripCost) {
		
		//Display output
		
		System.out.println("------------------------------------------------------------");
		System.out.println("-----------------------Results-Menu-------------------------");
		System.out.println("------------------------------------------------------------\n");
		
		System.out.println("The information on " + userName + "'s Vacation.\n");
		
		System.out.printf("%-20s%20s%3s%10s","\nLabel", "Name","  $", "Dollars");
		System.out.println("\n************************************************************");
		System.out.printf("%-20s%20s%3s%8.2f","\nDestination", destinationName,"  $", DEFAULT_LODGING_FEE);
		System.out.printf("%-20s%20s%3s%8.2f","\nTransportation", transportationName,"  $", transportationCost);
		System.out.printf("%-20s%20s%3s%8.2f","\nName of Upgrade(s)",upgradeName,"  $", upgradeCost);
		System.out.println("\n************************************************************");
		System.out.printf("%-20s%3s%6.2f","\n\tTotal Trip Cost","  $", totalTripCost);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Thank you for your time and have fun on your trip.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				
				
	}

	public static void farewellBanner(int counterDays, double completeTripCost) {
		
		System.out.println("------------------------------------------------------------\n");

		if(completeTripCost > 0.0) {
			
			System.out.println("Your trip is " + counterDays + " day(s)\n");
			System.out.printf("%-20s%6.2f%2s","Your trip costs $", completeTripCost, "\n");
			
		}
		System.out.println("Thank you for your time and we hope to see you again.");
		
		System.out.println("------------------------------------------------------------\n");
		
		

	}

}//End of Main
