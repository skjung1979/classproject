package Q200;

import java.util.ArrayList;
import java.util.*;

public class EnhancedFor {

	public static void main(String[] args) {

		int[] aa = {5,4,7,1,9,12,0,3,2,6};
		for(int i=0; i<aa.length; i++) {
			System.out.print("["+aa[i]+"]");
		}
		System.out.println();
		for(int en : aa) {
			System.out.printf("[%d]",en);
		}
		System.out.println();
		String[] sNames = {"봄","여름","가을","겨울"};
		for(String s : sNames) {
			System.out.printf("[%s]", s);
		}
		System.out.println();
		int[][] bb = {{1,2,3},{4,5,6},{7,8,9}};
		for(int[] outs : bb) {
			for(int ins : outs) {
				System.out.printf("[%d]",ins);
			}
			System.out.println();
		}
		System.out.println();
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("소나무");
		list.add("잣나무");
		list.add("전나무");
		list.add("삼나무");
		
		for(String sName : list) {
			System.out.printf("[%s]", sName);
		}
		System.out.println();
	
	}

}
