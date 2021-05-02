package Level1.D0501;

public class 음양더하기 {

	public static void main(String[] args) {
		Solution_02 st = new Solution_02();
		int[] absolutes = { 4, 7, 12 };
		boolean[] signs = { true, false, true };
		System.out.println(st.solution(absolutes, signs));

	}

}

class Solution_02 {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for (int i = 0; i < signs.length; i++) {
			if (signs[i]) {
				answer += absolutes[i];
			} else {
				answer -= absolutes[i];
			}
		}

		return answer;
	}
}