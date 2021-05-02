package Level1.D0430;

public class 이016년 {

	public static void main(String[] args) {
		Solution_02 st = new Solution_02();
		int a = 5, b = 24;
		System.out.println(st.solution(a, b));
	}
}

class Solution_02 {

	static int[] bArray = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static String[] answerArray = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
	// static String[] answerArray1 = { "��", "��", "��", "��", "ȭ", "��", "��" };

	public String solution(int a, int b) {
		String answer = "";

		int sum = 0;

		if (a > 1) {
			for (int i = 0; i < a - 1; i++) {
				System.out.println("i : " + i);
				sum += bArray[i];
			}
		}

		sum += b;
		sum -= 1;
		sum = sum % 7;

		answer = answerArray[sum];

		return answer;
	}
}
