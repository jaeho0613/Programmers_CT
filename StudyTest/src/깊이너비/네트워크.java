package 깊이너비;

public class 네트워크 {

	public static void main(String[] args) {

		Solution_02 st = new Solution_02();

		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

		System.out.println(st.solution(n, computers));
	}
}

class Solution_02 {
	public int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n];

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				answer++;
				dfs(computers, visited, i);
			}
		}

		return answer;
	}

	private void dfs(int[][] computers, boolean[] visited, int i) {
		visited[i] = true;

		for (int j = 0; j < computers.length; j++) {
			if (i != j && computers[i][j] == 1 && !visited[j]) {
				dfs(computers, visited, j);
			}
		}

		return;
	}
}