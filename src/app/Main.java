package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Game;
import entities.User;
import entities.difficulty.Difficulty;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("I'm thinking of a number between 1 and 100.");
		System.out.println("You have a X chances to guess the correct number.");
		
		System.out.println();
		System.out.println("First, let's register you.");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Gender: ");
		String gender = sc.nextLine();
		
		User user = new User(name, gender);
		Game game;
		
		System.out.println();
		int optionMenu;
		do {
			System.out.println("Choose an option for continuos.");
			System.out.println("[1] Play");
			System.out.println("[2] Statics");
			System.out.println("[0] Exit");
			
			System.out.println();
			System.out.println("Choose your option: ");
			optionMenu = sc.nextInt();
			
			switch(optionMenu) {
			case 1: 
				System.out.println("Please select the difficulty level:");
				System.out.println("[1] Easy (10 chances)");
				System.out.println("[2] Medium (5 chances)");
				System.out.println("[3] Hard (3 chances)");
				
				System.out.println();
				System.out.print("Enter your choice: ");
				Difficulty difficulty = Difficulty.fromOption(sc.nextInt());
				
				game = new Game(user, difficulty);
				
				while (!game.isOver()) {
                    System.out.println();
                    System.out.print("Enter your guess: ");
                    int guess = sc.nextInt();
                    game.guess(guess);
                    System.out.println("Remaining attempts: " + game.getRemainingAttempts());
                }
                break;
                
			case 2:
				System.out.println();
				System.out.println(user);
				break;
				
			case 3:
				System.out.println();
				System.out.println("Thanks for playing! See you next time.");
				break;
				
			default:
				System.out.println("Invalid option. Try again.");
			}
			
		} while (optionMenu != 0);
		
		sc.close();
	}
}
