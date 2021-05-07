package chapter03;

import java.util.*;

public class p96 {

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 3, 1, 2 }, { 4, 1, 4 }, { 2, 2, 2 } };
		int[][] arr2 = new int[][] { { 7, 3, 1, 8 }, { 3, 3, 3, 4 } };
		Solution st = new Solution();
		
		System.out.println(st.solution(arr));
		System.out.println(st.solution(arr2));
	}
}

class Solution {
	public int solution(int[][] arr) {
		List<Integer> answer = new ArrayList<>();

		for (int[] temp : arr) {
			int min = temp[0];
			for (int num : temp) {
				if (min > num) {
					min = num;
				}
			}
			answer.add(min);
		}

		return Collections.max(answer);
	}
}
