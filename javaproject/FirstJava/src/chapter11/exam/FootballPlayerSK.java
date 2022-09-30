package chapter11.exam;

public class FootballPlayerSK implements Comparable<FootballPlayerSK> {
	
	private String name;
	private int backNumber;
	private String teamName;
	private int age;
	
	public FootballPlayerSK(String name, int backNumber, String teamName, int age) {
		super();
		this.name = name;
		this.backNumber = backNumber;
		this.teamName = teamName;
		this.age = age;
	}

	public FootballPlayerSK() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBackNumber() {
		return backNumber;
	}

	public void setBackNumber(int backNumber) {
		this.backNumber = backNumber;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return age;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj != null && obj instanceof FootballPlayerSK) {
			FootballPlayerSK player = (FootballPlayerSK)obj;
			result = teamName.equals(player.getTeamName())
					&& name.equals(player.getName())
					&& age == player.getAge();
			
		}

		
		return result;
	}
	
	@Override
	public int compareTo(FootballPlayerSK o) {
		int result = teamName.compareTo(o.getTeamName());
		if(result == 0) {
			result = name.compareTo(o.getName());
			if(result == 0) {
				result = backNumber - o.getBackNumber();
			}
		}
		return result*-1; // 역순
	}
	
	@Override
	public String toString() {
		return "FootballPlayerSK [name=" + name + ", backNumber=" + backNumber + ", teamName=" + teamName + ", age="
				+ age + "]";
	}
	
	
	
	
	

}
