package season02;

public class 음양더하기 {

	public static void main(String[] args) {

		Solution st = new Solution();

		int[] absolutes = { 4, 7, 12 };
		boolean[] signs = { true, false, true };

		System.out.println(st.solution(absolutes, signs));
	}

}

class Solution {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for (int i = 0; i < signs.length; i++) {
			int temp = absolutes[i];
			if (signs[i]) {
				answer += temp;
			} else {
				answer -= temp;
			}
		}

		return answer;
	}
}