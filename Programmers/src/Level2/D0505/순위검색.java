package Level2.D0505;

import java.util.*;

// https://www.youtube.com/watch?v=eBQtFteduyw
public class 순위검색 {

	public static void main(String[] args) {
//		Solution_02 st = new Solution_02();
		Solution_02_outer st = new Solution_02_outer();
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		int[] result = st.solution(info, query);

		for (int i : result) {
			System.out.println(i + " ");
		}

	}

}

class Solution_02_outer {
    public int[] solution(String[] infos, String[] querys) {
        int[] answer = new int[querys.length];
        Map<String, Map<String, Map<String, Map<String, List<Integer>>>>> applierTree = new HashMap<>();

        for(String info : infos){
            String splitted[] = info.split(" ");
            Map<String, Map<String, Map<String, List<Integer>>>> stage1 = applierTree.get(splitted[0]);
            if(stage1 == null){
                stage1 = new HashMap<>();
                applierTree.put(splitted[0], stage1);
            }

            Map<String, Map<String, List<Integer>>> stage2 = stage1.get(splitted[1]);
            if(stage2 == null){
                stage2 = new HashMap<>();
                stage1.put(splitted[1], stage2);
            }

            Map<String, List<Integer>> stage3 = stage2.get(splitted[2]);
            if(stage3 == null){
                stage3 = new HashMap<>();
                stage2.put(splitted[2], stage3);
            }

            List<Integer> stage4 = stage3.get(splitted[3]);
            if(stage4 == null){
                stage4 = new ArrayList<>();
                stage3.put(splitted[3], stage4);
            }
            stage4.add(Integer.parseInt(splitted[4]));
        }


        for(String key1 : applierTree.keySet()){
            Map<String, Map<String, Map<String, List<Integer>>>> stage1 = applierTree.get(key1);
            for(String key2 : stage1.keySet()){
                Map<String, Map<String, List<Integer>>> stage2 = stage1.get(key2);
                for(String key3 : stage2.keySet()){
                    Map<String, List<Integer>> stage3 = stage2.get(key3);
                    for(String key4 : stage3.keySet()){
                        List<Integer> stage4 = stage3.get(key4);
                        stage4.sort(Comparator.naturalOrder());
                    }
                }
            }
        }



        int idx = 0;
        for(String query: querys){
            String splitted[] = query.split(" and ");
            String splitted2[] = splitted[3].split(" ");
            final int score = Integer.parseInt(splitted2[1]);
            int sum = 0;
            for(String key1 : applierTree.keySet()){
                if(key1.equals(splitted[0]) || splitted[0].equals("-")){
                    Map<String, Map<String, Map<String, List<Integer>>>> stage1 = applierTree.get(key1);

                    for(String key2 : stage1.keySet()){
                        if(key2.equals(splitted[1]) || splitted[1].equals("-")){
                            Map<String, Map<String, List<Integer>>> stage2 = stage1.get(key2);

                            for(String key3 : stage2.keySet()){
                                if(key3.equals(splitted[2]) || splitted[2].equals("-")){
                                    Map<String, List<Integer>> stage3 = stage2.get(key3);


                                    for(String key4 : stage3.keySet()){
                                        if(key4.equals(splitted2[0]) || splitted2[0].equals("-")){
                                            List<Integer> stage4 =  stage3.get(key4);
                                            int tempIdx = searchIdx(stage4, score, 0, stage4.size()-1);
                                            
                                            if(stage4.get(tempIdx) >= score)
                                                sum += stage4.size() - tempIdx;
                                            else
                                                sum += stage4.size() - tempIdx - 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
            answer[idx++] = sum;
        }
        return answer;
    }
    int searchIdx(List<Integer> list, int num, int start, int end){
        if(start >= end) return start;
        int middle = (start+end)/2;
        if(list.get(middle) >= num)
            return searchIdx(list, num, start, middle-1);
        return searchIdx(list, num, middle+1, end);
    }
}

// 영상 풀이
class Solution_02 {

	Map<String, Integer> Wordmap = new HashMap<>();
	List<List<Integer>> ScoreList = new ArrayList<List<Integer>>();

	public int[] solution(String[] info, String[] query) {
		Wordmap.put("-", 0);
		Wordmap.put("cpp", 1);
		Wordmap.put("java", 2);
		Wordmap.put("python", 3);

		Wordmap.put("backend", 1);
		Wordmap.put("frontend", 2);

		Wordmap.put("junior", 1);
		Wordmap.put("senior", 2);

		Wordmap.put("chicken", 1);
		Wordmap.put("pizza", 2);

		// 초기화
		for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
			ScoreList.add(new ArrayList<>());
		}

		for (String str : info) {
			String[] word = str.split(" ");
			int[] arr = { Wordmap.get(word[0]) * 3 * 3 * 3, Wordmap.get(word[1]) * 3 * 3, Wordmap.get(word[2]) * 3,
					Wordmap.get(word[3]) };

			int score = Integer.parseInt(word[4]);

			for (int i = 0; i < (1 << 4); i++) {
				int idx = 0;
				for (int j = 0; j < 4; j++) {
					if ((i & (1 << j)) != 0) {
						idx += arr[j];
					}
				}
				ScoreList.get(idx).add(score);
			}
		}

		for (int i = 0; i < 4 * 3 * 3 * 3; i++) {
			Collections.sort(ScoreList.get(i));
		}

		int[] answer = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			String[] word = query[i].split(" ");
			int idx = Wordmap.get(word[0]) * 3 * 3 * 3 + Wordmap.get(word[2]) * 3 * 3 + Wordmap.get(word[4]) * 3
					+ Wordmap.get(word[6]);
			int score = Integer.parseInt(word[7]);
			int ret = Collections.binarySearch(ScoreList.get(idx), score);
			if (ret < 0) {
				ret = -(ret + 1);
			} else {
				for (int j = ret - 1; j >= 0; j--) {
					if (ScoreList.get(idx).get(j) == score) {
						ret = j;
					} else {
						break;
					}
				}
			}
			answer[i] = ScoreList.get(idx).size() - ret;
		}

		return answer;
	}
}

// (나의 풀이)실패 
//class Solution_02 {
//
//	public int[] solution(String[] info, String[] query) {
//		int[] answer = new int[info.length];
//		List<Tester> testerList = new ArrayList<>();
//		for (String str : info) {
//			String[] sp = str.split(" ");
//			testerList.add(new Tester().setLanguage(sp[0]).setJob(sp[1]).setCareer(sp[2]).setFood(sp[3])
//					.setScore(Integer.parseInt(sp[4])));
//		}
//
//		for (int i = 0; i < query.length; i++) {
//			String[] tokens = query[i].split(" ");
//			for (Tester tester : testerList) {
//				boolean isSame = true;
//				for (int j = 0; j < tokens.length; j++) {
//					if (!tokens[j].equals("and") && !tokens[j].equals("-") && j != tokens.length - 1) {
//						if (!tester.isQueryCheck(tokens[j])) {
//							isSame = false;
//							continue;
//						}
//					}
//
//					if (j == tokens.length - 1) {
//						if (!tester.isHight(Integer.parseInt(tokens[j]))) {
//							isSame = false;
//							continue;
//						}
//					}
//				}
//
//				if (isSame) {
//					answer[i]++;
//				}
//			}
//		}
//
//		return answer;
//	}
//}
//
//class Tester {
//	String language;
//	String job;
//	String career;
//	String food;
//	int score;
//
//	public boolean isQueryCheck(String token) {
//		String tester = this.toString();
//		if (!tester.contains(token)) {
//			return false;
//		}
//		return true;
//	}
//
//	public boolean isHight(int num) {
//		if (score >= num) {
//			return true;
//		} else {
//			return false;
//		}
//
//	}
//
//	public String getLanguage() {
//		return language;
//	}
//
//	public Tester setLanguage(String language) {
//		this.language = language;
//		return this;
//	}
//
//	public String getJob() {
//		return job;
//	}
//
//	public Tester setJob(String job) {
//		this.job = job;
//		return this;
//	}
//
//	public String getCareer() {
//		return career;
//	}
//
//	public Tester setCareer(String career) {
//		this.career = career;
//		return this;
//	}
//
//	public String getFood() {
//		return food;
//	}
//
//	public Tester setFood(String food) {
//		this.food = food;
//		return this;
//	}
//
//	public int getScore() {
//		return score;
//	}
//
//	public Tester setScore(int score) {
//		this.score = score;
//		return this;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder st = new StringBuilder();
//		st.append(language + " ");
//		st.append(job + " ");
//		st.append(career + " ");
//		st.append(food + " ");
//		st.append(score);
//		return st.toString();
//	}
//
//}