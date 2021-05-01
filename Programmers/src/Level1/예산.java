package Level1;

import java.util.Arrays;

public class 예산 {

	public static void main(String[] args) {
		Solution_asd st = new Solution_asd();
//		int[] d = { 1, 3, 2, 5, 4 };
//		int budget = 9;
//		int[] d = { 2, 2, 3, 3 };
//		int budget = 10;
//		int[] d = { 1,2,2,3,4,5 };
//		int budget = 9;
		int[] d = { 1 };
		int budget = 1;

		System.out.println(st.solution(d, budget));

	}

}

class Solution_asd {
	public int solution(int[] d, int budget) {

		Arrays.sort(d);

		if (d[0] > budget)
			return 0;

		int answer = 1;
		int sum = d[0];

		for (int i = 1; i < d.length; i++) {
			sum += d[i];
			if (sum <= budget) {
				answer++;
				System.out.println("sum : " + sum);
			}
		}

		return answer;
	}
}