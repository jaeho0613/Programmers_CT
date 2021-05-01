package Level1;

public class 내적 {
	public static void main(String[] args) {
		Solution_awnd st = new Solution_awnd();
		int[] a = { 1, 2, 3, 4 };
		int[] b = { -3, -1, 0, 2 };
		System.out.println(st.solution(a, b));
	}
}

class Solution_awnd {
	public int solution(int[] a, int[] b) {
		int answer = 0;
		
		for (int i = 0; i < a.length; i++) {
			answer += (a[i] * b[i]);
		}
		
		return answer;
	}
}
