package Level2.D0505;

import java.util.*;

// https://www.youtube.com/watch?v=22tBC3YXVPA 해설
public class 메뉴리뉴얼 {

	public static void main(String[] args) {
		Solution st = new Solution();

		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
//		String[] orders = { "ACD" };
		int[] course = { 2, 3, 4 };

		String[] result = st.solution(orders, course);
		for (String str : result) {
			System.out.println(str);
		}
	}
}

class Solution {
	List<Map<String, Integer>> FoodMaps = new ArrayList<>();
	int[] MaxCnt = new int[11];

	public String[] solution(String[] orders, int[] course) {

		// FoodMaps 초기화
		for (int i = 0; i < 11; i++) {
			FoodMaps.add(new HashMap<String, Integer>());
		}

		for (String str : orders) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			comb(arr, 0, new StringBuilder());
		}

		List<String> list = new ArrayList<>();
		for (int len : course) {
			for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
				if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
					list.add(entry.getKey());
				}
			}
		}

		Collections.sort(list);

		return list.toArray(new String[list.size()]);
	}

	private void comb(char[] arr, int pos, StringBuilder sb) {
		if (pos >= arr.length) {
			int len = sb.length();
			if (len >= 2) {
//				System.out.println(sb.toString());
				int cnt = FoodMaps.get(len).getOrDefault(sb.toString(), 0) + 1;
				FoodMaps.get(len).put(sb.toString(), cnt);
				MaxCnt[len] = Math.max(MaxCnt[len], cnt);
			}
			return;
		}

//		System.out.println("선택함 pos : " + pos + " " + sb.toString());
		comb(arr, pos + 1, sb.append(arr[pos]));

		sb.setLength(sb.length() - 1);

//		System.out.println("선택안함 pos : " + pos + " " + sb.toString());
		comb(arr, pos + 1, sb);

	}
}

//class Solution {
//	List<Map<String, Integer>> FoodMaps = new ArrayList<>();
//	int[] MaxCnt = new int[11];
//
//	public String[] solution(String[] orders, int[] course) {
//
//		// orders는 2~ 10이상의 문자열
//		for (int i = 0; i < 11; ++i) {
//			FoodMaps.add(new HashMap<String, Integer>());
//		}
//
//		for (String str : orders) {
//			System.out.println("==============");
//			char[] arr = str.toCharArray();
//			Arrays.sort(arr);
//			comb(arr, 0, new StringBuilder());
//			System.out.println("==============");
//		}
//
//		List<String> list = new ArrayList<>();
//		for (int len : course) {
//			for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
//				if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
//					list.add(entry.getKey());
//				}
//			}
//		}
//
//		Collections.sort(list);
//
//		String[] answer = new String[list.size()];
//		for (int i = 0; i < answer.length; i++) {
//			answer[i] = list.get(i);
//		}
//		return answer;
//	}
//
//	private void comb(char[] str, int pos, StringBuilder candi) {
//
//		if (pos >= str.length) {
//			int len = candi.length();
//			if (len >= 2) {
//				System.out.println(candi.toString());
//				int cnt = FoodMaps.get(len).getOrDefault(candi.toString(), 0) + 1;
//				FoodMaps.get(len).put(candi.toString(), cnt);
//				MaxCnt[len] = Math.max(MaxCnt[len], cnt);
//			}
//			return;
//		}
//
//		// 선택함
//		comb(str, pos + 1, candi.append(str[pos]));
////		System.out.println("선택함 : " + candi.toString());
//
//		// 복원
//		candi.setLength(candi.length() - 1);
//
//		// 선택 안함
//		comb(str, pos + 1, candi);
////		System.out.println("선택안함 : " + candi.toString());
//
//	}
//}
