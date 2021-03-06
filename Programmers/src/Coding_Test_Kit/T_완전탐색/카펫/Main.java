package Coding_Test_Kit.T_완전탐색.카펫;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
		int[] result = st.solution(14,4);
		for (int i : result) {
			System.out.println(i);
		}
	}
}

class Solution {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int x, y = 0;
		int sum = (brown + 4) / 2;

		for (y = 3; y <= sum; y++) {
			x = sum - y;
			if (x < y)
				break;

			if ((x - 2) * (y - 2) == yellow) {
				answer[0] = x;
				answer[1] = y;
				break;
			}
		}

		return answer;
	}
}