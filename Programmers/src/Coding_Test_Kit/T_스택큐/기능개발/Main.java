package Coding_Test_Kit.T_스택큐.기능개발;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();

		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

//		int[] progresses = { 95, 90, 99, 99, 80, 99 };
//		int[] speeds = { 1, 1, 1, 1, 1, 1 };

		st.solution(progresses, speeds);
		int[] result = st.solution(progresses, speeds);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> answer = new ArrayList<Integer>();

		for (int i = 0; i < progresses.length; i++) {
			int day = ((100 - progresses[i]) % speeds[i]) > 0 ? ((100 - progresses[i]) / speeds[i]) + 1
					: ((100 - progresses[i]) / speeds[i]);

			queue.add(day);
		}

		int prevFunc = queue.poll();
		int numOfFuncs = 1;
		while (!queue.isEmpty()) {
			int curFunc = queue.poll(); // ���� ó������ ����� �� ��ȯ (Queue ��ü �����Ͱ� ������� ����)
			if (prevFunc >= curFunc) {
				numOfFuncs++;
			} else {
				answer.add(numOfFuncs);
				numOfFuncs = 1;
				prevFunc = curFunc;
			}
		}
		answer.add(numOfFuncs);

		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
