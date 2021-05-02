package Level1.D0501;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		Solution_05 st = new Solution_05();
//		int[] arr = { 5, 9, 7, 10 };
//		int divisor = 5;

		int[] arr = { 3, 2, 6 };
		int divisor = 10;

		int[] result = st.solution(arr, divisor);

		for (int i : result) {
			System.out.print(i + " ");
		}
	}

}

class Solution_05 {
	public int[] solution(int[] arr, int divisor) {
		List<Integer> answer = new ArrayList<>();

		for (int num : arr) {
			if (num % divisor == 0) {
				answer.add(num);
			}
		}

		Collections.sort(answer);

		if (answer.isEmpty()) {
			answer.add(-1);
		}

		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
