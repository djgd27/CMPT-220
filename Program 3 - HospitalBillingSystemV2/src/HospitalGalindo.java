// David Galindo Delgado
// Prog3Galindo
// Due Date and Time: 02/08/2024 before 09:00 a.m.
//
// Purpose: To practice conditional statements and loops. 
//           Program will help Hospital process insurance payments
//
// Input: User inputs patient ID, household income, insurance plan, and number of days patient stayed in hospital
// 
// Output: all of the charges (medical bill). 
//		Patient ID, household income, insurance plan, number of days, 
//		admittance fee, per diem rate, service fee, discount(if applicable), and total bill 
//
// Certification of Authenticity:
//     I certify that this lab is entirely my own work.

import java.util.*;

public class HospitalGalindo 
{
    // declare one keyboard for the project
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String args[]) 
    {
        // declare and initialize variables
    	int patientID = 0;
    	double householdIncome = 0.00;
    	String insurInput = "?";
    	char checkInsurance = '?';
    	String insurancePlan = "?"; 	
        int numOfDays = 0;
        double admitFee = 300.00;
        double serviceFee = 0.00;
        double perDiem = 0.00;
        double discount = 0.00;
        double totalBill = 0.00;
        boolean checkDiscount;

        //declare and initialize new variables for prog3
        int totalPatients = 0;
        int highPatientID = 0; 
        double highBillPaid = 0.00;
        double sumOfBills = 0.00;
        double avgBillAmnt = 0.00;
        
        // greet the user and declare the program
        System.out.println("\nWelcome to the Hospital Insurance Processor!");
        System.out.println("User inputs a Patients data");
        System.out.println("I will output the Admittance Fee, Per Diem Rate, Service Fee, Discount and Total Bill,"
        		+ "\n and a summary consisting of the total number of patients processed, the highest bill paid,"
        		+ "\n the patient ID associated with the highest bill, the total amount of all bills processed,"
        		+ "\n and the average bill amount");
        
        // get user input
        System.out.println("\nEnter valid patient data when prompted");
        System.out.print("Enter (integer) Patient ID, [0]zero to quit: ");
        patientID = keyboard.nextInt();
        
        // pre-condition checks if user wants to quit, 
        //	 otherwise continue getting user input
        while (patientID != 0)
        {
            //validate household income input
        	do
        	{
                System.out.print("Household Income: ");
        		householdIncome = keyboard.nextDouble();
        	}//do
        	while (householdIncome < 0);	
        	
        	//validate insurance plan input
        	do
        	{
        		System.out.print("\n[R]ed Cross" + "\n[M]id-Hudson"
        						+ "\n[A]ca" + "\n[N]o Insurance"
        						+ "\nInsurance Plan: ");
        		insurInput = keyboard.next().toUpperCase();
        		checkInsurance = insurInput.charAt(0);
        	}//do	
        	while (!(checkInsurance == 'R' || checkInsurance == 'M' 
        			|| checkInsurance == 'A' || checkInsurance == 'N'));
        	
        	// validate number of days input
        	do
        	{
        		System.out.print("Enter Number of Days: ");
        		numOfDays = keyboard.nextInt();
        	}//do
        	while (numOfDays < 1 || numOfDays > 366);
        	
        	//check if discount is applicable to patient
        	checkDiscount = (numOfDays > 23);
        	if (checkDiscount == true)
        	{
        		discount = numOfDays / 7;
        		discount = discount * 250;
        	}//if
        	else 
        		discount = 0;
        	
        	// compute patient fees
        	switch (checkInsurance)
            {
        	    case 'R' :
        		    insurancePlan = "Red Cross";
        		    if (householdIncome < 15000)
        			    perDiem = 50;
        		    else if (householdIncome <= 37500)
        			    perDiem = 70;
        		    else
        			    perDiem = 150;
        		    break;
        	    case 'M' : 
        		    insurancePlan = "Mid-Hudson";
        		    if (householdIncome < 20000)
        			    perDiem = 40;
        		    else if (householdIncome <= 45000)
        			    perDiem = 75;
        		    else
        			    perDiem = 110;
        		    break;
        	    case 'A':
        		    insurancePlan = "ACA";
        		    if (householdIncome < 12500)
        			    perDiem = 60;
        		    else if (householdIncome <= 53000)
        			    perDiem = 75;
        		    else
        			    perDiem = 140;
        		    break;
        	    case 'N':
        		    insurancePlan = "No Insurance";
        		    perDiem = 350;
            }//switch
        	
        	// compute service fee and total bill
        	serviceFee = numOfDays * perDiem;
        	totalBill = admitFee + serviceFee - discount;
        	
        	// output patient receipt
        	System.out.println("\n######  Patient Receipt  ######");
            System.out.println(" Patient ID number: " + patientID);
            System.out.printf(" Household Income: $%.2f\n", householdIncome);
            System.out.println(" Insurance Plan: " + insurancePlan);
            System.out.println(" Number of Days: " + numOfDays);
            System.out.println("\n######  Payment Due  ######");
            System.out.printf(" Admittance Fee: $%.2f\n", admitFee);
            System.out.printf(" Per Diem Rate: $%.2f\n", perDiem);
            System.out.printf(" Service Fee: $%.2f\n", serviceFee);
            System.out.printf(" Discount: -$%.2f\n", discount);
            System.out.println("\n#######################");
            System.out.printf(" Total Bill: $%.2f", totalBill);
            System.out.println("\n#######################");
        	
            //compute number of patients processed, the highest bill paid,
            //PatientID associated with the highest bill, and total sum of all bills processed
            totalPatients++;
            if (totalBill > highBillPaid)
            {
            	highBillPaid = totalBill;
            	highPatientID = patientID;
            }//if
            sumOfBills += totalBill;
            
        	System.out.print("\nEnter (integer) Patient ID, [0]zero to quit: ");
            patientID = keyboard.nextInt();        
        }//while             
        
        //compute average bill amount if data has been entered
        if (totalPatients > 0)
        {
        	avgBillAmnt = sumOfBills / totalPatients;
        	
        	//output final summary
            System.out.println("\n##################   Summary   ##################");
            System.out.println(" Toatl number of patients processed: " + totalPatients);
            System.out.printf(" Highest Bill Paid: $%.2f\n", highBillPaid);
            System.out.println(" Patient ID associated with the highest bill: " + highPatientID);
            System.out.printf(" Total amount of all bills processed: $%.2f\n", sumOfBills);
            System.out.printf(" Average bill amount: $%.2f", avgBillAmnt);
            System.out.println("\n################################################");
        }
        else
        	System.out.println("\nYou entered ZERO (0) patient data");
        
        //end of program    
        System.out.println("\nThanks!   Goodbye");	
		keyboard.close();
		
    }//main
}//HospitalGalindo        
