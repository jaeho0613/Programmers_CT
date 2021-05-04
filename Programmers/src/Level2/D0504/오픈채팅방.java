package Level2.D0504;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class 오픈채팅방 {

	public static void main(String[] args) {
		Solution_02 st = new Solution_02();

		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		String[] result = st.solution(record);

		for (String string : result) {
			System.out.println(string);
		}
	}

}

class Solution_02 {

	public static Map<String, String> userList = new HashMap<String, String>();
	public static Queue<String> inOutQueue = new ArrayDeque<String>();
	public static Queue<String> uidQueue = new ArrayDeque<String>();

	public String[] solution(String[] record) {
		List<String> answer = new ArrayList<>();

		// 회원 가입
		for (String cord : record) {
			String[] temp = cord.split(" ");
			if (!temp[0].equals("Leave")) {
				signIn(temp[1], temp[2]);
			}

			if (!temp[0].equals("Change")) {
				inOutQueue.add(temp[0]);
				uidQueue.add(temp[1]);
			}
		}

		// 출입명부
		while (!inOutQueue.isEmpty()) {
			String inOut = inOutQueue.poll();
			String nickName = userList.get(uidQueue.poll());
//			System.out.println(inOut);
//			System.out.println(nickName);
			switch (inOut) {
			case "Enter":
				answer.add(nickName + "님이 들어왔습니다.");
				break;
			case "Leave":
				answer.add(nickName + "님이 나갔습니다.");
				break;
			}
		}

		return answer.toArray(new String[answer.size()]);
	}

	// 회원가입
	private void signIn(String uid, String nickName) {
		userList.put(uid, nickName);
	}
}