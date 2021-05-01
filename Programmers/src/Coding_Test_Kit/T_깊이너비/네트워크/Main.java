package Coding_Test_Kit.T_깊이너비.네트워크;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
		Solution2 st2 = new Solution2();

		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		System.out.println(st.solution(n, computers));
		System.out.println();
		System.out.println(st2.solution(n, computers));
	}

}

class Solution2 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] check = new boolean[n];

		for (int i = 0; i < check.length; i++) {
			if (!check[i]) {
				answer++;
				dfs(computers, i, check);
			}
		}

		return answer;
	}

	private boolean[] dfs(int[][] computers, int i, boolean[] check) {
		check[i] = true;

		for (int j = 0; j < computers.length; j++) {
			if (j != i && computers[i][j] == 1 && check[j] == false) {
				check = dfs(computers, j, check);
			}
		}

		return check;
	}
}

class Solution {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] check = new boolean[n]; // n ������ŭ boolean �迭�� ����� ��� ��Ҹ� false�� �ʱ�ȭ

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				dfs(computers, i, check);
				answer++;
			}
		}

		return answer;
	}

	boolean[] dfs(int[][] computers, int i, boolean[] check) {
		check[i] = true;

		for (int j = 0; j < computers.length; j++) {
			if (i != j && computers[i][j] == 1 && check[j] == false) {
				check = dfs(computers, j, check);
			}
		}
		return check;
	}
}