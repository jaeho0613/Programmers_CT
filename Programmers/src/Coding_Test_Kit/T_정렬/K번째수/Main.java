package Coding_Test_Kit.T_정렬.K번째수;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] result = st.solution(array, commands);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < commands.length; i++) {
			int[] command = commands[i];
			List<Integer> dammy = new ArrayList<>();
//			System.out.println("0 : " + (command[0] - 1));
//			System.out.println("1 : " + (command[1] - 1));
//			System.out.println();

			for (int j = command[0] - 1; j <= command[1] - 1; j++) {
				dammy.add(array[j]);
			}

			Collections.sort(dammy);
//			for (Integer integer : dammy) {
//				System.out.print(integer + " ");
//			}
//			System.out.println();
			answer.add(dammy.get(command[2] - 1));
		}
		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
