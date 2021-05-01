package Coding_Test_Kit.T_정렬.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
		int[] numbers = { 6, 10, 2 }; // 6210
		System.out.println(st.solution(numbers));
	}
}

class Solution {
	public String solution(int[] numbers) {
		String answer = "";

		String[] stringNumbers = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
//			System.out.println("value : " + String.valueOf(numbers[i]));
			stringNumbers[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(stringNumbers, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				System.out.print("o1 : " + o1 + "/ o2 : " + o2 + "/ ");
				System.out.println();
				System.out.println("o1 + o2 : " + (o1 + o2));
				System.out.println("o2 + o1 : " + (o2 + o1));
				System.out.println((o2 + o1).compareTo(o1 + o2));
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		for (int i = 0; i < stringNumbers.length; i++) {
			answer += stringNumbers[i];
		}

		if (answer.charAt(0) == '0')
			answer = "0";

		return answer;
	}
}