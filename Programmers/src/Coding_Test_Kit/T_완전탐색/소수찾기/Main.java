package Coding_Test_Kit.T_완전탐색.소수찾기;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
		System.out.println(st.solution("17"));
	}
}

class Solution {
	static boolean[] check = new boolean[7];
	static int answer = 0;
	static ArrayList<Integer> arr = new ArrayList<>();

	public int solution(String numbers) {
		String temp = "";

		for (int i = 1; i <= numbers.length(); i++) {
			rec(numbers, temp, i);
		}
		
		for (Integer integer : arr) {
			System.out.println(integer);
		}

		for (int x : arr) {
			cal(x);
		}

		return answer;
	}

	public static void cal(int n) {
		if (n == 0)
			return;
		if (n == 1)
			return;

		System.out.println("sqrt : " + Math.sqrt(n));

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return;
		}

		answer++;
	}

	public static void rec(String n, String temp, int len) {
		if (temp.length() == len) {
			if (!arr.contains(Integer.parseInt(temp)))
				arr.add(Integer.parseInt(temp));
			return;
		}

		for (int j = 0; j < n.length(); j++) {
			if (check[j])
				continue;

			temp += n.charAt(j);

			check[j] = true;
			rec(n, temp, len);
			check[j] = false;

			temp = temp.substring(0, temp.length() - 1);
		}
	}
}
