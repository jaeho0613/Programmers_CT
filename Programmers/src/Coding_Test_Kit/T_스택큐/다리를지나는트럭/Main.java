package Coding_Test_Kit.T_스택큐.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {

		Solution st = new Solution();

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };

		System.out.println(st.solution(bridge_length, weight, truck_weights));
	}
}

class Solution {

	class Truck {
		int weight;
		int move;

		public Truck(int weight) {
			this.weight = weight;
			this.move = 1;
		}

		public void moving() {
			move++;
		}
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {

		Queue<Truck> waitQ = new LinkedList<Truck>();
		Queue<Truck> moveQ = new LinkedList<Truck>();

		for (int t : truck_weights) {
			waitQ.offer(new Truck(t));
		}

		int answer = 0;
		int curWeight = 0;

		while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
			answer++;

			// �����̴� Ʈ���� ���� ���
			if (moveQ.isEmpty()) {
				Truck t = waitQ.poll();
				curWeight += t.weight;
				moveQ.offer(t);
				continue;
			}

			// Ʈ���� ������
			for (Truck t : moveQ) {
				t.moving();
			}

			// �����̴� Ʈ�� ������ ������ �ٸ� ���̿� ���� (peek�� ������ ������ ����)
			if (moveQ.peek().move > bridge_length) {
				Truck t = moveQ.poll();
				curWeight -= t.weight;
			}

			// ���� ��ٸ��� Ʈ���� �ְ� (���� �ٸ��� ���� + ���� Ʈ���� ����) <= �ٸ��� ���� ���� �۴ٸ� Ʈ�� �߰�
			if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
				Truck t = waitQ.poll();
				curWeight += t.weight;
				moveQ.offer(t);
			}
		}

		return answer;
	}
}
