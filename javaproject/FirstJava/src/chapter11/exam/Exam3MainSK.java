package chapter11.exam;

import java.util.TreeSet;

public class Exam3MainSK {

	public static void main(String[] args) {
		
		TreeSet<FootballPlayerSK> players = new TreeSet<>();
		
		players.add(new FootballPlayerSK("손흥민", 7,"토트넘", 20));
		players.add(new FootballPlayerSK("케인", 10,"토트넘", 19));
		players.add(new FootballPlayerSK("황희찬", 11,"울버햄튼", 18));
		players.add(new FootballPlayerSK("이강인", 5,"발렌시아", 17));
		players.add(new FootballPlayerSK("황의조", 10,"토트넘", 22));
		players.add(new FootballPlayerSK("손흥민", 11,"토트넘", 20));
		
		System.out.println("보유 선수의 수: " + players.size());

		System.out.println("===보유선수 리스트===");
		for (FootballPlayerSK p : players) {
			System.out.println(p);
		}
		
	}
	
	
}
