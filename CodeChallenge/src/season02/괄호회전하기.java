package season02;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class 괄호회전하기 {

	public static void main(String[] args) {
		Solution_02 st = new Solution_02();

		String s = "[](){}";
		String s1 = "}]()[{";

		System.out.println(st.solution(s1));

	}

}

class Solution_02 {
	Queue<String> sQueue = new ArrayDeque<>();
	int answer = 0;

	public int solution(String s) {

		int sLength = s.length();

		for (int i = 0; i < sLength; i++) {
			sQueue.add(String.valueOf(s.charAt(i)));
		}

		for (int i = 0; i < sLength; i++) {
			if (i == 0) {
				CheckString();
			} else {
				SwitchQueue();
				CheckString();
			}
		}

		return answer;
	}

	private void CheckString() {

		String[] copyArray = sQueue.toArray(new String[sQueue.size()]);
		for (String string : copyArray) {
			System.out.print(string + " ");
		}
		System.out.println();
		Stack<String> st = new Stack<>();

		for (int i = 0; i < copyArray.length; i++) {
			String word = copyArray[i];
			if (st.isEmpty()) {
				st.push(word);
				continue;
			}

			if (word.equals(")") && st.peek().equals("(")) {
				st.pop();
			} else if (word.equals("}") && st.peek().equals("{")) {
				st.pop();
			} else if (word.equals("]") && st.peek().equals("[")) {
				st.pop();
			} else {
				st.push(word);
			}
		}

		if (st.isEmpty()) {
			answer++;
		}
	}

	private void SwitchQueue() {
		String temp = sQueue.poll();
		sQueue.add(temp);
	}
}