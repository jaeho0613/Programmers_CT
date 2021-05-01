package Coding_Test_Kit.T_정렬.Hindex;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution st = new Solution();
		int[] citations1 = { 3, 0, 6, 1, 6 }; // 3
		int[] citations2 = { 12, 11, 10, 9, 8, 1 }; // 5
		int[] citations3 = { 6, 6, 6, 6, 6, 1 }; // 5
		int[] citations4 = { 4, 4, 4 }; // 3
		int[] citations5 = { 4, 4, 4, 5, 0, 1, 2, 3 }; // 4
		int[] citations6 = { 10, 11, 12, 13 }; // 4
		int[] citations7 = { 3, 0, 6, 1, 5 }; // 3
		int[] citations8 = { 0, 0, 1, 1 }; // 1
		int[] citations9 = { 0, 1 }; // 1
		int[] citations10 = { 10, 9, 4, 1, 1 }; // 3

		System.out.println("=====================");
		System.out.println(st.solution(citations1));
		System.out.println("=====================");
		System.out.println(st.solution(citations2));
		System.out.println("=====================");
		System.out.println(st.solution(citations3));
		System.out.println("=====================");
		System.out.println(st.solution(citations4));
		System.out.println("=====================");
		System.out.println(st.solution(citations5));
		System.out.println("=====================");
		System.out.println(st.solution(citations6));
		System.out.println("=====================");
		System.out.println(st.solution(citations7));
		System.out.println("=====================");
		System.out.println(st.solution(citations8));
		System.out.println("=====================");
		System.out.println(st.solution(citations9));
		System.out.println("=====================");
		System.out.println(st.solution(citations10));
		System.out.println("=====================");
	}

}

class Solution {
	public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		
		for (int i = 0; i < citations.length; i++) {
			int h = citations.length - i;
			if (citations[i] >= h) {
				System.out.println("citations: " + citations[i]);
				System.out.println("h : " + h);
				answer = h;
				break;
			}
		}

		return answer;
	}
}
