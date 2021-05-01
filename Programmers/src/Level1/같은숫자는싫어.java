package Level1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
	public static void main(String[] args) {
		Solution_awd st = new Solution_awd();
//		int[] arr = {1,1,3,3,0,1,1};
		int[] arr = {4,3};
		int[] temp = st.solution(arr);
		
		for (int i : temp) {
			System.out.print(i + " ");
		}
	}
}

class Solution_awd {
	public int[] solution(int[] arr) {
		List<Integer> answer = new ArrayList<>();

		int temp = 99;

		for (int num : arr) {
			if (num != temp) {
				temp = num;
				answer.add(num);
			}
		}

		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
