package craps;
import java.security.SecureRandom;

public class Craps {
	
	private static final SecureRandom secureRandom = new SecureRandom();
	
	//enum type with constants that represent the game status
	private enum Status {CONTINUE, WON, LOST};
	
	private static final int SNAKE_EYES = 2;
	private static final int TREY = 3;
	private static final int SEVEN = 7;
	private static final int LEGS_ELEVEN = 11;
	private static final int BOX_CARS = 12;

	public static void main(String[] args) {
		int myPoint = 0; //point if no win or lose on first roll
		Status gameStatus; //can contain CONTINUE, WON OR LOST
		
		int sumOfDice = rollDice(); //first roll of the dice
		
		//determine the game status and point based on the first roll
		switch (sumOfDice) {
			case SEVEN: //win with 7 on first roll
			case LEGS_ELEVEN:
				gameStatus = Status.WON;
				break;
			case SNAKE_EYES:
			case TREY:
			case BOX_CARS:
				gameStatus = Status.LOST;
				break;
			default:
				gameStatus = Status.CONTINUE; //die not win or lose, so remember the points
				myPoint = sumOfDice; //assigning points
				System.out.printf("Point is %d%n", myPoint);
		}
		
		//while game is not complete
		while (gameStatus == Status.CONTINUE) {
			sumOfDice = rollDice();
		
		if(sumOfDice == myPoint) {
			gameStatus = Status.WON;
		} else {
			if(sumOfDice == SEVEN) {
				gameStatus = Status.LOST;
			}
		}
	}
		if (gameStatus == Status.WON) {
			System.out.println ("Player wins");
		} else {
			System.out.println("Player loses");
		}	
	}
	
	public static int rollDice() {
		int die1 = 1 + secureRandom.nextInt(6);
		int die2 = 1 + secureRandom.nextInt(6);
		
		int sum = die1 + die2;
		
		System.out.printf("Player rolled %d + %d = %d %n", die1, die2, sum);
		
		return sum;
	}

}
