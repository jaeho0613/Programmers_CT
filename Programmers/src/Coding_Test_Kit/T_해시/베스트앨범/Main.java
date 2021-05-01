package Coding_Test_Kit.T_해시.베스트앨범;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		Solution2 st = new Solution2();

//		String[] genres = { "classic", "pop", "classic", "classic", "pop" };
//		int[] plays = { 500, 600, 150, 800, 2500 };

//		String[] genres = { "no1", "no2", "no1" };
//		int[] plays = { 1, 2, 3 };

//		String[] genres = { "no1", "no2", "no1", "no3", "no1" };
//		int[] plays = { 1, 2, 3, 10, 4 }; // 3 4 2 1

//		String[] genres = {"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"};
//		int[] plays = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

		String[] genres = { "A", "A", "B", "A", "B", "B" };
		int[] plays = { 5, 5, 6, 5, 7, 7 };

		int[] result = st.solution(genres, plays);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}

}

// ���� Ǭ(�̿ϼ�)
class Solution {
	public int[] solution(String[] genres, int[] plays) {

		List<Integer> result = new ArrayList<Integer>();

		// ���� �����
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < genres.length; i++) {
			hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
		}

		// hm�� key�� ���� �������� ����
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(hm.entrySet());
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		// ������ key��
		List<String> keyRank = new ArrayList<String>();
		for (Entry<String, Integer> entry : list_entries) {
			keyRank.add(entry.getKey());
		}

		for (String key : keyRank) {
			System.out.println("key : " + key + " value : " + hm.get(key));
		}

		for (int j = 0; j < keyRank.size(); j++) {

			int a = 0; // �ι�°�� ���� �����
			int b = 0; // ���� ���� �����

			for (int i = 0; i < genres.length; i++) {
				if (keyRank.get(j).equals(genres[i])) {
					System.out.println("========");
					System.out.println(i + " rank : " + keyRank.get(j));
					System.out.println("========");

					if (b < plays[i]) {
						int temp = b;
						b = plays[i];
						a = temp;
					}
				}
			}

			System.out.println("a �ι�°�� ����  : " + a);
			System.out.println("b ���� ���� : " + b);

			for (int i = 0; i < plays.length; i++) {
				if (b == plays[i]) {
//					System.out.println("b - i: " + i);
					result.add(i);
				}
			}

			for (int i = 0; i < plays.length; i++) {
				if (a == plays[i] && a != 0) {
//					System.out.println("a - i: " + i);
					result.add(i);
				}
			}
		}

//		for (int rank : result) {
//			System.out.println(rank);
//		}

		return result.stream().mapToInt(i -> i.intValue()).toArray();
	}
}

// �ٸ� ����� Ǭ
class Solution2 {
	public int[] solution(String[] genres, int[] plays) {

		HashMap<String, Integer> hm = new HashMap<String, Integer>(); // �帣�� ���Ƚ���� ���ϱ� ���� hashmap���
		for (int i = 0; i < genres.length; i++) { // hashmap�� �帣�� �÷��� Ƚ�� ����
			hm.put(genres[i], hm.getOrDefault(genres[i], 0) + plays[i]);
		}

		ArrayList<Integer> answers = new ArrayList<Integer>(); // ���߿� int[]������ �ٲ㼭 ������ arrayList
		ArrayList<String> al = new ArrayList<String>(hm.keySet()); // Value�� ������������ �����ϱ� ���� ����
		Collections.sort(al, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1)))); // ArrayList�� hm Value �������� ������ ����

		for (int i = 0; i < al.size(); i++) { // ��, ���� ���� ���๮
			String TempGenres = al.get(i);
			int firstIdx = 0;
			int secondIdx = 0;
			int max = 0;
			for (int j = 0; j < genres.length; j++) { // ù��° �� ���ϱ�
				if (TempGenres.equals(genres[j])) { // ���� ������ ������ �帣�� genres�迭�� ���� ������
					if (plays[j] > max) { // max�� ���ؼ� �ִ� ����
						max = plays[j];
						firstIdx = j;

						System.out.println("max : " + max);
						System.out.println("firstIdx : " + firstIdx);
					}
				}
			}
			
			System.out.println("========================");

			max = -1; // �帣�� �ϳ��� �� �����Ƿ� -1
			for (int j = 0; j < genres.length; j++) { // �ι�° �� ���ϱ�
				if (TempGenres.equals(genres[j])) {
					if (j != firstIdx && plays[j] > max) {
						max = plays[j];
						secondIdx = j;

						System.out.println("max : " + max);
						System.out.println("secondIdx : " + secondIdx);
					}
				}
			}
			
			System.out.println("========================");
			
			answers.add(firstIdx); // ���� ū �� �߰�
			if (max != -1) {
				answers.add(secondIdx); // ���� ū �� �߰�
			}
		}

		return answers.stream().mapToInt(Integer::intValue).toArray();

	}
}