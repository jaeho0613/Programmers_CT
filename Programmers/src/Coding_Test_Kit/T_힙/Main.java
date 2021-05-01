package Coding_Test_Kit.T_힙;

import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
//		Solution2 st = new Solution2();

//		int[] scoville = { 1, 2, 3, 9, 10, 12 };
//		int K = 7; // 2

//		int[] scoville = { 1, 1, 1 };
//		int K = 4; // 2

		int[] scoville = { 10, 10, 10, 10, 10 };
		int K = 100; // 4

//		int[] scoville = { 1, 2, 3, 9, 10, 12 };
//		int K = 7; // 2

//		int[] scoville = { 0, 2, 3, 9, 10, 12 };
//		int K = 7; // 2

//		int[] scoville = { 0, 0, 3, 9, 10, 12 };
//		int K = 7; // 3

//		int[] scoville = { 0, 0, 3, 9, 10, 12 };
//		int K = 700; // -1

//		int[] scoville = { 0, 0, 3, 9, 10, 12 };
//		int K = 0; // 0

//		int[] scoville = { 0, 0, 3, 9, 10, 12 };
//		int K = 1; // 2

//		int[] scoville = { 0, 0 };
//		int K = 0; // 0

//		int[] scoville = { 0, 0 };
//		int K = 1; // -1

//		int[] scoville = { 1, 0 };
//		int K = 1; // 1

//		int[] scoville = { 0, 0, 2 };
//		int K = 2; // 2

		System.out.println(st.solution(scoville, K));
	}
}

class Solution2 {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> heap = new PriorityQueue();

		for (int aScoville : scoville) {
			heap.offer(aScoville);
		}

		while (heap.peek() <= K) {
			if (heap.size() == 1) {
				return -1;
			}
			int a = heap.poll();
			int b = heap.poll();

			int result = a + (b * 2);

			heap.offer(result);
			answer++;
		}
		return answer;
	}
}

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		for (int num : scoville) {
			heap.add(num);
		}

		while (heap.peek() <= K) {
			if (heap.size() == 1) {
				return -1;
			}
			int a = heap.poll();
			int b = heap.poll();
//			System.out.println("a : " + a + " b : " + b);

			int result = a + (b * 2);

			heap.add(result);
			answer++;
		}

		return answer;
	}
}
