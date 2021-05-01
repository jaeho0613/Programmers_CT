package Coding_Test_Kit.T_탐욕법.체육복;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();

		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };

//		int[] lost = { 2, 4 };
//		int[] reserve = { 3 };

//		int[] lost = { 3, 4, 5 };
//		int[] reserve = { 1, 3, 5 };

		System.out.println(st.solution(n, lost, reserve));
	}

}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // ���� ü������ ������ �л��� �������� ���
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i] == reserve[j]){
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        
        // �������� �л����� ü���� �����ִ� ���
        for(int i=0; i<lost.length; i++){
            for(int j=0; j<reserve.length; j++){
                if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])){
                    answer++;
                    reserve[j] = -1; 
                    break; 
                }
            }
        }
        return answer;
    }
}
