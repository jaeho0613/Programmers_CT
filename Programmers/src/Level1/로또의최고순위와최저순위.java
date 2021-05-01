package Level1;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {
	public static void main(String[] args) {
		Solution_awdg st = new Solution_awdg();
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
		int[] result = st.solution(lottos, win_nums);

		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}

class Solution_awdg {
	public int[] solution(int[] lottos, int[] win_nums) {

		int min = 0;
		int max = 0;
		int temp = 0;

		boolean[] check = new boolean[46];

		for (int num : lottos) {
			if (num == 0) {
				temp++;
			}
			check[num] = true;
		}

		for (int num : win_nums) {
			if (check[num]) {
				min++;
			}
		}

		max = min + temp;

		min = changeToRank(min);
		max = changeToRank(max);

		int[] answer = { max, min};

		return answer;
	}

	private int changeToRank(int num) {
		switch (num) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
}
