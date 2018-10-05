package edu.cpt.earl.program5;
import java.util.Scanner;

/** Vacation calculator: Assignment5
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

		String userName = "";
		String destinationName = "";
		double destinationCost = 0.0;
		String transportationName = "";
		double transportationCost = 0.0;
		String upgradeName = "";
		double upgradeCost = 0.0;
		
		
		welcomeBanner();
		
		userName = askUserName(input);
		
		destinationSlection = validateMainMenuSelection();
		
		transportationSlection = validateTransportationMenuSelection();
		
		upgradeSelection = validateUpgradeMenuSelection();
				
		destinationName = destinationDecider();
		
		transportationName = transportationDecider();
		
		transportationName = transportationCostDecider();
		
		upgradeName = upgradeDecider();
		
		upgradeCost = upgradeCostDecider();
		
	}//end of main
	
	public static void welcomeBanner() {
		
		System.out.println("------------------------------------------------------------");
		System.out.println("    Hello and Welcome to the Vacation Calulation Machine!\n");
		System.out.println("This program is designed to assist you with finding");
		System.out.println("the cost of a Vacation to several locations.");
		System.out.println("------------------------------------------------------------\n");
		
	}//end of welcomeBanner
	
	
	public static String askUserName(Scanner borrowedInput) {
		
		System.out.println("To begin, What is your name? ");
		
		System.out.println("");
		System.out.print(": ");
		
		userName = borrowedInput.nextLine();
		
		return userName;
		
	}//end askUserName
	
	public static char validateMainMenuSelection(Scanner borrowedInput) {
	
		char localMenuAnswer = ' ';
		
		System.out.println("----------------------------New Menu------------------------\n");
		System.out.println("Travel Destination Selection:\n");
		System.out.printf("%-3s%30s%3s%6.2f","\n|A|", DESTINATION_ROME_ITALY,"  $",DEFAULT_LODGING_FEE);
		System.out.printf("%-3s%30s%3s%6.2f","\n|B|", DESTINATION_LONDON_ENGLAND,"  $",DEFAULT_LODGING_FEE);
		System.out.printf("%-3s%30s%3s%6.2f","\n|C|", DESTINATION_KEY_WEST_FLORDIA,"  $",DEFAULT_LODGING_FEE);
		
		System.out.println("");
		System.out.println("");
		System.out.print(": ");
		
		localMenuAnswer = borrowedInput.nextLine().charAt(0);
		
		localMenuAnswer = Character.toLowerCase(localMenuAnswer);
		
		while (localMenuAnswer != 'a' && localMenuAnswer != 'b' && localMenuAnswer != 'c') {
			
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
	
	public static char validateTransportationMenuSelection(Scanner borrowedInput) {
		
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
		
	}//end of validateTransportationMenuSelection
	
	public static char validateUpgradeMenuSelection() {
		
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
		
		localMenuAnswer = input.nextLine().charAt(0);
		
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
			
			localMenuAnswer = input.nextLine().charAt(0);
			
			localMenuAnswer = Character.toLowerCase(localMenuAnswer);
			
		}//end of validateUpdateMenuSelection while loop
		
	}//end of validateUpdateMenuSelection
	
	public static String destinationDecider() {
		
		if (localMenuAnswer == 'a') {
			destination = DESTINATION_ROME_ITALY;
		}
		else if(localMenuAnswer == 'b') {
			destination = DESTINATION_LONDON_ENGLAND;
		}
		else {
			destination = DESTINATION_KEY_WEST_FLORDIA;
		}
		
		return destination
				
	}//end of destinationDecider
	
	public static String transportationDecider() {
			
		if (localMenuAnswer == 'a') {
			
			modeOfTransport = TRANSPORT_AIRPLANE;
			
		}
		else {
			
			modeOfTransport = TRANSPORT_SHIP;
			
		}
		
		return modeOfTransport;
		
	}//end of transportationDecider
	
	public static String transportationCostDecider(transportationMenuAnswer) {
		
		if (localMenuAnswer == 'a') {
			
			modeOfTransportCost = AIRPLANE_COST;
		}
		else {
			
			modeOfTransportCost = SHIP_COST;
		}
		
		return modeOfTransCost;
		
	}//end of transportationCostDecider
	
	public static String upgradeDecider() {
		
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
		
	}//end of upgradeDecider
	
	public static String upgradeCostDecider() {
		
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
		
	}//end of upgradeCostDecider

}//End of Main
