package Level1.D0430;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class 크레인인형뽑기 {

	public static void main(String[] args) {

		Solution st = new Solution();

		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };

		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(st.solution(board, moves));
	}
}

class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		List<Queue<Integer>> boardQue = new ArrayList<Queue<Integer>>();
		Stack<Integer> out = new Stack<Integer>();

		for (int i = 0; i < board.length; i++) {
			Queue<Integer> dammy = new LinkedList<Integer>();
//			System.out.println("===========" + i + "��°=========");
			for (int j = 0; j < board.length; j++) {
				if (board[j][i] != 0) {
					dammy.add(board[j][i]);
//					System.out.println(board[j][i]);
				}
			}
//			System.out.println("======================");
			boardQue.add(dammy);
		}

		for (int i = 0; i < moves.length; i++) {
			int num = moves[i] - 1;
//			System.out.println("input : " + boardQue.get(num).peek());
			if (out.isEmpty()) {
				out.add(boardQue.get(num).poll());
			} else if (!boardQue.get(num).isEmpty()) {
//				System.out.println("===========================");
//				System.out.println("out peek      : " + out.peek());
//				System.out.println("boardQue peek : " + boardQue.get(num).peek());
				if (out.peek() == boardQue.get(num).peek()) {
					out.pop();
					boardQue.get(num).poll();
					answer += 2;
				} else {
					int temp = boardQue.get(num).poll();
//					System.out.println("���� num : " + temp);
					out.add(temp);
//					System.out.println("�ٸ��Ƿ� out ����");
				}
//				System.out.println("===========================");
			}
		}

		return answer;
	}
}