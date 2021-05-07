package 깊이너비;

public class 타겟넘버 {

	public static void main(String[] args) {
		Solution st = new Solution();

		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		System.out.println(st.solution(numbers, target));
	}

}

class Solution {
	int answer = 0;

	public int solution(int[] numbers, int target) {

		dfs(numbers, target, 0, 0);

		return answer;
	}

	private void dfs(int[] numbers, int target, int sum, int node) {
		if (node == numbers.length) {
			if (sum == target) {
				answer++;
			}
			return;
		}
		
		dfs(numbers, target, sum + numbers[node], node + 1);
		dfs(numbers, target, sum - numbers[node], node + 1);
	}
}