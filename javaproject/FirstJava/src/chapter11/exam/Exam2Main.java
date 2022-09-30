package chapter11.exam;

import java.util.HashSet;
import java.util.Set;

public class Exam2Main {

	public static void main(String[] args) {
		// 2. 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고
		// 입력이 되지 않도록 Set<E> 컬렉션을 이용해서
		// 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다. 
		
		// Set<E> : 중복 허용 않함, 저장 순서도 유지하지 않음.
		// 중복 검사: hashCode 코드로 검사 -> equals를 통해 중복 검사

		Set<FootballPlayer> players = new HashSet<FootballPlayer>();
				
		FootballPlayer player = new FootballPlayer("손흥민", 7,"토트넘", 20);
		players.add(player);		
		players.add(new FootballPlayer("케인",10,"토트넘",25));
		players.add(new FootballPlayer("이강인",25,"토트넘",20));
		players.add(new FootballPlayer("황희찬",8,"울버햄튼",24));
		players.add(new FootballPlayer("박지성",9,"맨유",39));
		players.add(new FootballPlayer("손흥민", 7,"토트넘", 20));
		
		System.out.println("보유 선수의 수: " + players.size());
		
		System.out.println("===보유선수 리스트===");
		for(FootballPlayer p : players) {
			System.out.println(p);
		}
		
	}
}
