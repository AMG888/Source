package monty;

/*
 * 8 Ball is a java simulation of an eight ball
 * Authors Mark McGrane
 * and Ben Mc Grane
 */

import java.util.Random;
import java.util.Scanner;

public class EightBall {

	private static int y;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String [] eightBallAnswerArray = new String [11];

		eightBallAnswerArray[0] = "I dont know";
		eightBallAnswerArray[1] = "I love you more than pizza";
		eightBallAnswerArray[2] = "I'd like a double cheeseburger and hold the lettuce";
		eightBallAnswerArray[3] = "Ask somone else";
		eightBallAnswerArray[4] = "I'm bored answering you";
		eightBallAnswerArray[5] = "That's umpossible";
		eightBallAnswerArray[6] = "No..... I mean Yes";
		eightBallAnswerArray[7] = "Yes I do like it";
		eightBallAnswerArray[8] = "No I don't";
		eightBallAnswerArray[9] = "I'm going to sleep";
		eightBallAnswerArray[10] = "Ben.. do you need a drink?";


		Random random = new Random();
		System.out.println("Enter your question.........");
		String s = input.nextLine();
		input.close();
		System.out.println("You asked me...... " + s);



		System.out.printf("let me think :).");
		for (int i=0;i<50;i++){
			try {
				Thread.sleep(50);
				System.out.printf(".");
			} catch (InterruptedException e) {
				System.out.println("Thread sleeping error");
				e.printStackTrace();
			}
		}

		y = random.nextInt(eightBallAnswerArray.length);

		System.out.printf("%n");
		System.out.println(eightBallAnswerArray[y]);
	}
}
