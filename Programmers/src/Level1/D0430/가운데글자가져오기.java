package Level1.D0430;

public class 가운데글자가져오기 {
	public static void main(String[] args) {

		Solution_12 st = new Solution_12();

		String s = "abcdef";

		System.out.println(st.solution(s));
	}
}

class Solution_12 {
	public String solution(String s) {
		String answer = "";

		if (s.length() % 2 == 0) {
			answer = s.substring((s.length() / 2) - 1, (s.length() / 2) + 1);
		} else {
			answer = s.substring(s.length() / 2, (s.length() / 2) + 1);
		}

		return answer;
	}
}