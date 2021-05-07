package 깊이너비;

import java.util.*;

public class 여행경로 {

	public static void main(String[] args) {
		Solution_04 st = new Solution_04();

		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };

//		String[][] tickets2 = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };

		String[] result = st.solution(tickets);

		for (String string : result) {
			System.out.println(string);
		}
	}
}

class Solution_04 {

	List<String> answers;
	boolean[] visited;

	public String[] solution(String[][] tickets) {

		answers = new ArrayList<>();
		visited = new boolean[tickets.length];

		dfs(0, "ICN", "ICN", tickets);
		Collections.sort(answers);
		String[] answer = answers.get(0).split(" ");

		return answer;
	}

	private void dfs(int count, String current, String answer, String[][] tickets) {
		if(count == tickets.length) {
			answers.add(answer);
			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && tickets[i][0].equals(current)) {
				visited[i] = true;
				dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
				visited[i] = false;
			}
		}
	}
}