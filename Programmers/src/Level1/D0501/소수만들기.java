package Level1.D0501;

import java.util.Arrays;

public class 소수만들기 {

	public static void main(String[] args) {
		Solution_04 st = new Solution_04();
		int[] nums = { 1, 2, 7, 6, 4 };

		System.out.println(st.solution(nums));
	}

}

class Solution_04 {

	public static boolean[] prime;

	public int solution(int[] nums) {
		Arrays.sort(nums);
		int answer = 0;
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		checkToPrime(sum);

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int temp = nums[i] + nums[j] + nums[k];
					if (!prime[temp]) {
						answer++;
					}
				}
			}
		}

		return answer;
	}

	private void checkToPrime(int num) {

		// 0,1은 소수가 아님
		if (num == 0 || num == 1)
			return;

		// 0 ~ num 까지 이므로
		prime = new boolean[num + 1];
		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(num); i++) {

			// 이미 체크했다면 건너뜀
			if (prime[i]) {
				continue;
			}

			for (int j = i * i; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}
	}
}
