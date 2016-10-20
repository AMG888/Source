package monty;


/*
 * Full program to simulate the Monty Hall problem
 * using Java. Doors represented by a three element
 * int array. Zeroes in two random indices for the goats
 * and a one in the remaining index representing the car.
 * Monty is represented by a unnamed default abstract superclass. 
 * Copyright (c) Alan McGrane 2016 Version 1.3
 */

import java.util.Scanner;


public class MontyHallProblem {
	
	static long startTime = System.nanoTime();

	public static void main(String[] args) {



		Scanner input = new Scanner(System.in);
		System.out.printf("Please enter number of iterations....");
		int x = input.nextInt();
		input.close();
		System.out.println();
		calcMonty(x);
		System.out.println();
		calcMontyNoSwap(x);

	}

	/*
	 * Method to simulate Monty Hall problem
	 * when contestant swaps doors.
	 */

	static void calcMonty(int iteration){
		//long startTime = System.nanoTime();
		int winCounter  = 0;
		int loseCounter  = 0;

		for (int i = 0; i < iteration; i++) {



			//Construct door array and assign car(1) to a random door.
			int [] monty = {0,0,0};		
			int assignCar = (int) (Math.random()*3);
			monty[assignCar] = 1;

			//Contestant picks a door
			int contestantChoice = (int) (Math.random()*3);

			//Monty picks a door with a goat(0)
			int montyChoice = (int) (Math.random()*3);
			while ((montyChoice == contestantChoice)  | (monty[montyChoice] ==1)) {
				montyChoice = (int) (Math.random()*3);
			}


			//Contestant swaps door

			int finalChoice =9; //9 would force error

			if (contestantChoice == 0 & montyChoice == 1)
				finalChoice =2;
			else if (contestantChoice == 0 & montyChoice == 2)
				finalChoice =1;
			else if (contestantChoice == 1 & montyChoice == 0)
				finalChoice =2;
			else if (contestantChoice == 1 & montyChoice == 2)
				finalChoice =0;
			else if (contestantChoice == 2 & montyChoice == 0)
				finalChoice =1;
			else if (contestantChoice == 2 & montyChoice == 1)
				finalChoice =0;
			
			if (monty[finalChoice] == 1){
				//	System.out.println("You won");
				winCounter +=1;}
			else{
				//	System.out.println("You lost");
				loseCounter +=1;}
		}

		double f = (double) (winCounter+loseCounter);
		f = winCounter/f*100;
		System.out.printf("%nSwap Totals....%n");
		System.out.printf("Iterations...  %d%n", (winCounter+loseCounter));
		System.out.printf("Total Wins %-7d Percentage wins:   %.2f%%%n", winCounter,f)  ;
		System.out.printf("Total Losses %-5d Percentage losses: %.2f%%%n" ,loseCounter,  (100-f));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Program running time: %d Nanoseconds%n%n", totalTime/100000);
		System.out.printf("******************");

	}
	
	/*
	 * Method to simulate Monty Hall problem
	 * when contestant does not swap doors.
	 */
	
	
	static void calcMontyNoSwap(int iteration){
		//long startTime = System.nanoTime();
		int winCounter  = 0;
		int loseCounter  = 0;

		for (int i = 0; i < iteration; i++) {



			//Construct 3 door [3] array and assign car (1) to a random door.
			//and goats (0) to the other two.
			
			int [] monty = {0,0,0};		
			int assignCar = (int) (Math.random()*3);
			monty[assignCar] = 1;

			//Contestant picks a door
			int contestantChoice = (int) (Math.random()*3);

			//Monty picks a door with a goat (0)
			int montyChoice = (int) (Math.random()*3);
			while ((montyChoice == contestantChoice)  | (monty[montyChoice] ==1)) {
				montyChoice = (int) (Math.random()*3);
			}


			//Calculate stats

			if (monty[contestantChoice] == 1){
				//	System.out.println("You won");  //test
				winCounter +=1;}
			else{
				//	System.out.println("You lost");  //test
				loseCounter +=1;}
		}

		double f = (double) (winCounter+loseCounter);
		f = winCounter/f*100;
		System.out.printf("%nNo Swap Totals....%n");
		System.out.printf("Iterations...  %d%n", (winCounter+loseCounter));
		System.out.printf("Total Wins %-7d Percentage wins:   %.2f%%%n", winCounter,f)  ;
		System.out.printf("Total Losses %-5d Percentage losses: %.2f%%%n" ,loseCounter,  (100-f));
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.printf("Program running time: %d Nanoseconds", totalTime/100000);

	}
}

/*
 * Sample Output for a million loops:
 * 
 
Please enter number of iterations....1000000


Swap Totals....
Iterations...  1000000
Total Wins 666270  Percentage wins:   66.63%
Total Losses 333730 Percentage losses: 33.37%
Program running time: 37360 Nanoseconds

******************

No Swap Totals....
Iterations...  1000000
Total Wins 333595  Percentage wins:   33.36%
Total Losses 666405 Percentage losses: 66.64%
Program running time: 39363 Nanoseconds

*/
