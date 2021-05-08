package season01;

import java.util.*;

public class 삼진법뒤집기 {

	public static void main(String[] args) {
		Solution_02 st = new Solution_02();
		System.out.println(st.solution(3));

	}

}

class Solution_02 {
	public int solution(int n) {
		Stack<Integer> answer = new Stack<>();
		int result = 0;

		while (n >= 3) {
			answer.add(n % 3);
			n /= 3;
		}

		answer.add(n);

		result += answer.pop();

		int count = 1;
		while (!answer.isEmpty()) {
			int temp = answer.pop();
			int index = (int) Math.pow(3, count);
			result += (temp * index);
			count++;
		}

		return result;
	}
}