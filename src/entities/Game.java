package entities;

import java.util.Random;

import entities.difficulty.Difficulty;

public class Game {

	private Integer secretNumber;
	private Integer remainingAttempts;
	private Integer attempts;
	private Boolean gameOver;
	private User user;
	
	public Game() {
	}
	
	public Game(User user, Difficulty difficulty) {
		if (user == null || difficulty == null) {
			throw new IllegalArgumentException("User and difficulty cannot be null");
		}
		this.user = user;
		this.remainingAttempts = difficulty.getMaxAttempts();
		this.secretNumber = new Random().nextInt(100) + 1;
		this.attempts = 0;
		this.gameOver = false;
	}

	public Integer getRemainingAttempts() {
		return remainingAttempts;
	}

	public void guess(int number) {
		if(isOver()) {
			System.out.println("The game is already over.");
			return;
		}
		
		remainingAttempts--;
		attempts++;
		
		if (number == secretNumber) {
			System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
			user.totalWins();
			gameOver = true;
		} else if(number < secretNumber) {
			System.out.println("Incorrect! The number is greater than " + number + ".");
		} else {
			System.out.println("Incorrect! The number is less than " + number + ".");
		}
		
		if (remainingAttempts == 0 && !gameOver) {
			System.out.println("Game over! The secret number was " + secretNumber + ".");
			gameOver = true;
		}
	}
	
	public boolean isOver() {
		return gameOver || remainingAttempts == 0;
	}
	
}
