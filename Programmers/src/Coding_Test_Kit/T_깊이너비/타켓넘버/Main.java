package Coding_Test_Kit.T_깊이너비.타켓넘버;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();

		int[] numbers = { 1, 1, 1 };
		int target = 3;

		System.out.println(st.solution(numbers, target));

	}

}

class mySolution {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		answer = dfs(numbers, 0, 0, target);
		return answer;
	}

	public int dfs(int[] numbers, int node, int sum, int target) {
		if (node == numbers.length) {
			if (sum == target) {
				return 1;
			}
			return 0;
		}

		return dfs(numbers, node + 1, sum + numbers[node], target)
				+ dfs(numbers, node + 1, sum - numbers[node], target);
	}
}

class Solution {
	public int solution(int[] numbers, int target) {
		int answer = 0;
		answer = dfs(numbers, 0, 0, target);
		return answer;
	}

	private int dfs(int[] numbers, int node, int sum, int target) {
		System.out.print("numbers ���� : " + numbers.length + " ");
		System.out.print("node : " + node + " ");
		System.out.print("sum : " + sum + " ");
		System.out.print("target : " + target + " ");
		System.out.println();
		if (node == numbers.length) {
			if (sum == target) {
				System.out.println("return 1");
				return 1;
			}
			System.out.println("return 0");
			return 0;
		}
		return dfs(numbers, node + 1, sum + numbers[node], target)
				+ dfs(numbers, node + 1, sum - numbers[node], target);
	}
}
