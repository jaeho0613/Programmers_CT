package Level1.D0501;

import java.util.TreeSet;

public class 두개뽑아서더하기 {

	public static void main(String[] args) {
		Solution_03 st = new Solution_03();
		int[] numbers = { 2, 1, 3, 4, 1 };

		int result[] = st.solution(numbers);

		for (int i : result) {
			System.out.print(i + " ");
		}

	}

}

class Solution_03 {
	public int[] solution(int[] numbers) {

		TreeSet<Integer> answer = new TreeSet<Integer>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < numbers.length; j++) {
				if (i == j)
					continue;
				answer.add(numbers[i] + numbers[j]);
			}
		}

		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}
}