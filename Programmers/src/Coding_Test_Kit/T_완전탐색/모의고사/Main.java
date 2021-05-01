package Coding_Test_Kit.T_완전탐색.모의고사;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
		int[] answers = { 1, 2, 3, 4, 5 };
		
		int[] result = st.solution(answers);
		for(int num : result) {
			System.out.println(num);
		}

	}

}

class Solution {
	public int[] solution(int[] answers) {

		int a = 0, b = 0, c = 0;

		int[] man1 = { 1, 2, 3, 4, 5 }; // 5
		int[] man2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8
		int[] man3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == man1[i % man1.length])
				a++;
			if (answers[i] == man2[i % man2.length])
				b++;
			if (answers[i] == man3[i % man3.length])
				c++;
		}

		int max = Math.max(Math.max(a, b), c);
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (a == max)
			list.add(1);
		if (b == max)
			list.add(2);
		if (c == max)
			list.add(3);

		return list.stream().mapToInt(i -> i.intValue()).toArray();
	}
}