package Coding_Test_Kit.T_깊이너비.여행경로;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
		String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };

		String[][] tickets2 = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };

		String[] result = st.solution(tickets2);

		for (String string : result) {
			System.out.println(string);
		}
	}
}

class Solution {
	boolean[] visited;
	ArrayList<String> answers;

	public String[] solution(String[][] tickets) {
		visited = new boolean[tickets.length];
		answers = new ArrayList<String>();
		int count = 0;
		dfs(count, "ICN", "ICN", tickets);
		Collections.sort(answers);
		String[] answer = answers.get(0).split(" ");
		return answer;
	}

	private void dfs(int count, String present, String answer, String[][] tickets) {
		if (count == tickets.length) {
			answers.add(answer);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (!visited[i] && tickets[i][0].equals(present)) {
				visited[i] = true;
				dfs(count + 1, tickets[i][1], answer + " " + tickets[i][1], tickets);
				visited[i] = false;
			}
		}
	}
}

class Solution2 {
	public String result = "";

	public String[] solution(String[][] tickets) {
		String[] answer;
		String target = "ICN";
		boolean[] check = new boolean[tickets.length];

		dfs(result, check, tickets, target, 0);

		answer = result.split("/");

		return answer;
	}

	private void dfs(String result, boolean[] check, String[][] tickets, String target, int node) {

		if (node >= check.length) {
			System.out.println("==============��================");
			System.out.print(result);
			System.out.println();
			System.out.print("���� : " + result.length());
			System.out.print("node : " + node);
			System.out.println();
//			return;
		}

		for (int i = 0; i < tickets.length; i++) {
			if (target.equals(tickets[i][0]) && !check[i]) {
				System.out.println("===========");
				System.out.println("target : " + target);
				System.out.println("tickets[" + i + "][1] : " + tickets[i][1]);
				System.out.println("node : " + node);
				System.out.println("i : " + i);
				System.out.println("===========");
				String temp = "";

				temp = target;

				result += "/" + target;
				if (i == tickets.length + 1) {
					result += "/" + tickets[i][1];
				}

				check[i] = true;
				target = tickets[i][1];
				dfs(result, check, tickets, target, node + 1);
				target = temp;
				check[i] = false;
			}
		}
		return;
	}
}