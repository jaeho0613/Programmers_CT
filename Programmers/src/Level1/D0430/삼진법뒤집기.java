package Level1.D0430;

import java.util.Stack;

public class 삼진법뒤집기 {

	public static void main(String[] args) {
		Solution_lja st = new Solution_lja();
		System.out.println(st.solution(3));
	}

}

class Solution_lja {
	public int solution(int n) {
		int answer = 0;
		Stack<Integer> temp = new Stack<Integer>();

		while (n >= 3) {
			temp.add(n % 3);
			n = n / 3;
		}
		
		temp.add(n);
//		System.out.println(temp);
		int index = 0;
		while (!temp.isEmpty()) {
			int dammy = Integer.parseInt(String.valueOf(temp.pop()));
//			System.out.println("dammy : " + dammy );
			if (index == 0) {
				answer += dammy;
			} else if (index == 1) {
				answer += (dammy * 3);
			} else {
				int in = (int) Math.pow(3, index);
				answer += dammy * in;
			}
			index++;
		}

		return answer;
	}
}
