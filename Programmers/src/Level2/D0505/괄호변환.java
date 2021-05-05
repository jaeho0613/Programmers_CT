package Level2.D0505;

import java.util.*;

// https://www.youtube.com/watch?v=Bc34h7xPTL8
public class 괄호변환 {

	public static void main(String[] args) {
		Solution_04 st = new Solution_04();

//		String p = "()))((()";
//		String p = ")(";
//		String p = ")(()";
//		String p = "))((())(";
		String p = ")(()()";
//		String p = ")))(((";

		System.out.println(st.solution(p));

	}
}

class Solution_04 {

	int pos;

	boolean isCorrect(String str) {

		// 올바른 문자열 확인
		boolean ret = true;

		// 왼쪽 괄호, 오른쪽 괄호
		int left = 0, right = 0;

		Stack<Character> mystack = new Stack<>();

		// u, v의 분류를 위한 pos찾기
		// - 균형잡힌 괄호 문자열, 더 이상 분리할 수 없어야함
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				left++;
				mystack.push('(');
			} else {
				right++;
				if (mystack.empty()) {
					System.out.println("비어있음");
					ret = false;
				} else {
					mystack.pop();
				}
			}

			if (left == right) {
				pos = i + 1;
				return ret;
			}
		}

		return true;

	}

	public String solution(String p) {

		// 1번
		if (p.isEmpty())
			return p;

		// 2번
		boolean correct = isCorrect(p);
		String u = p.substring(0, pos);
		String v = p.substring(pos, p.length());

		// 3번
		if (correct) {
			return u + solution(v);
		}

		// 4번
		String answer = "(" + solution(v) + ")";

		// 첫과 끝을 제거
		// - 시작과 마지막을 조정함
		for (int i = 1; i < u.length() - 1; i++) {
			if (u.charAt(i) == '(') {
				answer += ")";
			} else {
				answer += "(";
			}
		}

		return answer;
	}
}