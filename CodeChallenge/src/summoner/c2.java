package summoner;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class c2 {

	public static void main(String[] args) {
		Solution_02 st = new Solution_02();

//		int[] t = { 0, 1, 3, 0 };
//		int[] r = { 0, 1, 2, 3 };

		int[] t = { 7, 6, 8, 1 };
		int[] r = { 0, 1, 2, 3 };

		int[] result = st.solution(t, r);

		for (int i : result) {
			System.out.println(i + " ");
		}
	}

}

class Solution_02 {
	public int[] solution(int[] t, int[] r) {
		int currentTime = 0;
		Queue<Integer> redayQueue = new ArrayDeque<Integer>();
		PriorityQueue<Integer> goQueue = new PriorityQueue<Integer>();
		List<Integer> answer = new ArrayList<Integer>();

		List<Integer> tList = new ArrayList<Integer>();
		for (int num : t) {
			tList.add(num);
		}

		List<Integer> rList = new ArrayList<Integer>();

		int timeMax = Collections.max(tList);
		for (int timeCount = 0; timeCount <= timeMax; timeCount++) {
			for (int j = 0; j < tList.size(); j++) {
				if (timeCount == tList.get(j)) {
					rList.add(r[j]);
					redayQueue.add(r[j]);
				}
			}
		}
		Collections.sort(tList);

		for (Integer integer : rList) {
			System.out.print(integer + " ");
		}
		System.out.println();
		for (Integer integer : tList) {
			System.out.print(integer + " ");
		}

		while (!redayQueue.isEmpty()) {
//			System.out.println("currentTime" + currentTime);

			for (int i = 0; i < r.length; i++) {
				if (tList.get(i) == currentTime) {
					goQueue.add(redayQueue.poll());
//					System.out.println("poll");
				}
			}

//			System.out.println("gogo");
			if (!goQueue.isEmpty()) {
				answer.add(goQueue.poll());
			}
			currentTime++;
		}
		
		

		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}
}