// David Galindo Delgado
// Prog1Galindo
// Due Date and Time: 01/25/2024 before 09:00 a.m.
//
// Purpose: To calculate and output the results of the change needed by the inputed amount
//
// Input: The user will need to input the amount to be changed when asked by the program
//
// Output: The program will output the results of the change needed by which the user will input
//
// Certification of Authenticity:
// 		I certify that this lab is entirely my own work.

import java.util.*;

public class ChangeMakerGalindo
{
    //declare one keyboard for the project
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
	    //declare and initialize variables
		int amount = 0;
		int originalAmount = 0;
		int twentyDollarBills = 0;
		int tenDollarBills = 0;
		int fiveDollarBills = 0;
		int oneDollarBills = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		int billsTotal = 0;
		int coinsTotal = 0;
		
		//Greet the user and describe the program
		System.out.println("Welcome to the Change Maker system!");
		System.out.println("Enter a whole number.");
		System.out.println("I will output a combination of bills and coins");
		System.out.println("that equals that amount of change.");
		
		//Get the input
		System.out.print("\nEnter amount to be changed: ");
		amount = keyboard.nextInt();
		
		//calculate change
		originalAmount = amount;
		twentyDollarBills = amount / 2000;
		amount = amount % 2000;
		tenDollarBills = amount / 1000;
		amount = amount % 1000;
		fiveDollarBills = amount / 500;
		amount = amount % 500;
		oneDollarBills = amount / 100;
		amount = amount % 100;
		quarters = amount / 25;
		amount = amount % 25;
		dimes = amount / 10;
		amount = amount % 10;
		nickels = amount / 5;
		amount = amount % 5;
		pennies = amount;
		
		//calculate total 
		billsTotal = twentyDollarBills + tenDollarBills + fiveDollarBills + oneDollarBills;
		coinsTotal = quarters + dimes + nickels + pennies;
		
		//output the results
		System.out.println();
		System.out.println(originalAmount + " cents can be given as: ");
		System.out.println(twentyDollarBills + " twenty dollar bills");
		System.out.println(tenDollarBills + " ten dollar bills");
		System.out.println(fiveDollarBills + " five dollar bills");
		System.out.println(oneDollarBills + " one dollar bills");
		System.out.println(quarters + " quarters");
		System.out.println(dimes + " dimes");
		System.out.println(nickels + " nickels");
		System.out.println(pennies + " pennies");
		System.out.println("\nTotal number of bills used: " + billsTotal);
		System.out.println("Total number of coins used: " + coinsTotal);
		
		System.out.println("\nThankes!   Goodbye");	
		keyboard.close();
	} //main
} //ChangeMakerGalindo
