package summoner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c1 {

	public static void main(String[] args) {
		Solution st = new Solution();

		String code = "012345";
		String day = "20190620";
		String[] data = { "price=80 code=987654 time=2019062113", "price=90 code=012345 time=2019062014",
				"price=120 code=987654 time=2019062010", "price=110 code=012345 time=2019062009",
				"price=95 code=012345 time=2019062111" };

		int[] result = st.solution(code, day, data);

		for (int i : result) {
			System.out.print(i + " ");
		}

	}

}

class Solution {

	List<Company> companyList = new ArrayList<>();

	public int[] solution(String code, String day, String[] data) {
		List<Integer> answer = new ArrayList<>();
		List<Integer> timeList = new ArrayList<>();

		for (int i = 0; i < data.length; i++) {
			String temp = data[i];

			int codeIndex = temp.indexOf("code=");
			int timeIndex = temp.indexOf("time=");

			String price = temp.substring(6, codeIndex - 1);
			String codeT = temp.substring(codeIndex + 5, timeIndex - 1);
			String time = temp.substring(timeIndex + 5, temp.length());
			String t_time = time.substring(0, time.length() - 2);

			if (codeT.equals(code) && t_time.equals(day)) {
//				System.out.println(price);
//				System.out.println(codeT);
//				System.out.println(time);

				Company com = new Company();
				com.price = price;
				com.code = codeT;
				com.time = Integer.parseInt(time);
				companyList.add(com);
			}
		}

		for (Company com : companyList) {
			timeList.add(com.time);
		}

		Collections.sort(timeList);

		for (Integer time : timeList) {
			for (int i = 0; i < companyList.size(); i++) {
				if (time == companyList.get(i).time) {
					answer.add(Integer.parseInt(companyList.get(i).price));
				}
			}
		}

		return answer.stream().mapToInt(i -> i.intValue()).toArray();
	}

	class Company {
		public String price;
		public String code;
		public int time;
	}
}
