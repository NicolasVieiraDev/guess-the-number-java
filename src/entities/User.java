package entities;

public class User {

	private String name;
	private String gender;
	private Integer wins;
	
	public User() {
	}
	
	public User(String name, String gender) {
		if (name == null) {
			throw new IllegalArgumentException("Your name cannot be null, please writing another name!");
		}
		
		this.name = name;
		this.gender = (gender == null) ? "Uninformed" : gender;
		this.wins = 0;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getWins() {
		return wins;
	}

	public void totalWins() {
		this.wins += 1;
	}
	
	public String toString() {
		return "Name: "
				+ name
				+ "\n"
				+ "Gender: "
				+ gender
				+ "\n"
				+ "Wins today: "
				+ wins;
	}
}
