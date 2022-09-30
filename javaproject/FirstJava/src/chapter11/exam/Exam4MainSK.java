package chapter11.exam;

import java.util.HashMap;
import java.util.Map;

public class Exam4MainSK {

	public static void main(String[] args) {

		Map<Integer, FootballPlayerSK> players = new HashMap<>();
		
		players.put(1, new FootballPlayerSK("손흥민", 7,"토트넘", 20));
		players.put(1, new FootballPlayerSK("손흥민", 7,"토트넘", 30));
		
		// 데이타의 중복 저장이 안되니, 기존 값에 덮어 쓴다.
		System.out.println(players.get(1));

	}

}
