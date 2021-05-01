package Coding_Test_Kit.T_스택큐.주식가격;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

//		Solution st = new Solution();
		Solution2 st = new Solution2();
		int[] prices = { 1,2,3,2,3 };
		int[] result = st.solution(prices);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
}

// �ٸ� ��� Ǯ��
class Solution2 {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;
    }
}

class Solution {
	public int[] solution(int[] prices) {
		List<Integer> answer = new ArrayList<Integer>();

		for (int i = 0; i < prices.length; i++) {
			int count = 0;
			for (int j = i + 1; j < prices.length; j++) {
//				System.out.println("i : " + i + " j : " + j);

				if (prices[i] > prices[j]) {
//					System.out.println("!!!");
					count++;
					break;
				}
				count++;
			}
//			System.out.println("count : " + count);
			answer.add(count);
		}
		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}
}