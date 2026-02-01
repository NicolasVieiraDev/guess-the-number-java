package entities.difficulty;

public enum Difficulty {
	
	EASY(1, 10),
	MEDIUM(2, 5),
	HARD(3, 3);
	
	private int option;
	private final int maxAttempts;
	
	Difficulty(int option, int maxAttempts){
		this.option = option;
		this.maxAttempts = maxAttempts;
	}
	
	public int getMaxAttempts() {
		return maxAttempts;
	}
	
	public static Difficulty fromOption(int option) {
		for (Difficulty d : values()) {
			if (d.option == option) {
				return d;
			}
		}
		
		throw new IllegalArgumentException("Invalid option!");
	}
}
