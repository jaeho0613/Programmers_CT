package Coding_Test_Kit.T_스택큐.프린터;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Solution2 st = new Solution2();

		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		System.out.println(st.solution(priorities, location));
	}
}

class Solution2 {
	public int solution(int[] priorities, int location) {
		int answer = 0;
		int l = location;

		Queue<Integer> que = new LinkedList<Integer>();
		for (int i : priorities) {
			que.add(i);
		}

		Arrays.sort(priorities);
		int size = priorities.length - 1;

		while (!que.isEmpty()) {
			Integer i = que.poll();
			if (i == priorities[size - answer]) {
				answer++;
				l--;
				if (l < 0)
					break;
			} else {
				que.add(i);
				l--;
				if (l < 0)
					l = que.size() - 1;
			}
		}

		return answer;
	}
}

class Solution {
	public int solution(int[] priorities, int location) {

		int answer = 0;
		Queue<Printer> q = new LinkedList<>();

		for (int i = 0; i < priorities.length; i++) {
			q.offer(new Printer(i, priorities[i]));
		}

		while (!q.isEmpty()) {

			boolean flag = false;
			int com = q.peek().prior;
			for (Printer p : q) {
				if (com < p.prior) { // �Ǿ��� ������ ū ���ڰ� �����ϸ�
					flag = true;
				}
			}

			if (flag) {
				q.offer(q.poll());
			} else { // ���� �Ǿ��� ���ڰ� ���� Ŭ ��
				if (q.poll().location == location) {
					answer = priorities.length - q.size();
				}
			}
		}

		return answer;
	}
}

class Printer {
	int location;
	int prior;

	public Printer(int location, int prior) {
		this.location = location;
		this.prior = prior;
	}
}
