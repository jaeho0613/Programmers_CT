package Coding_Test_Kit.T_탐욕법.큰수만들기;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Solution2 st = new Solution2();

		String number = "4177252841";
		int k = 4;

		String number2 = "11111";
		int k2 = 2;

		String number3 = "1001";
		int k3 = 2;

		String number4 = "12";
		int k4 = 1;

		String number5 = "7777";
		int k5 = 3;

		String number6 = "4321";
		int k6 = 2;

		System.out.println(st.solution(number, k));
		System.out.println(st.solution(number2, k2));
		System.out.println(st.solution(number3, k3));
		System.out.println(st.solution(number4, k4));
		System.out.println(st.solution(number5, k5));
		System.out.println(st.solution(number6, k6));
	}

}

class Solution2 {
	public String solution(String number, int k) {
		char[] result = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		for (int i = 0; i < result.length; i++) {
			result[i] = stack.get(i);
		}
		
		return new String(result);
	}

class Solution {
	public String solution(String number, int k) {
		if(number.charAt(0) == '0') return "0";
		
		StringBuilder sb = new StringBuilder(number);
		
//		boolean isSame = true;
//		
//		for (int i = 0; i < sb.length(); i++) {
//			
//			if(sb.charAt(0) != sb.charAt(i)) {
//				isSame = true;
//				break;
//			} else {
//				isSame = false;
//			}
//		}
//		
//		if(!isSame) return sb.substring(0,number.length() - k);
		
		int length = number.length() - k;

		for (int i = 0; i < sb.length(); i++) {
			if (sb.length() == length)
				break;
			for (int j = i + 1; j <= i + 1 && j < sb.length(); j++) {
				if (sb.charAt(i) < sb.charAt(j)) {
					sb.delete(i,i+1);
					i = -1;
					break;
				}
			}
		}
		
		if(sb.length() == number.length()) return sb.substring(0,number.length() - k);

		return sb.toString();
	}
}}
