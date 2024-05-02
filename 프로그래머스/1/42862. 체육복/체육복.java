import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 체육수업을 들을 수 있는 학생 수 초기화
        int answer = n - lost.length;

        // 체육복 상태 배열
        boolean[] hasUniform = new boolean[n+1];

        // 잃어버린 학생과 여벌이 있는 학생의 처리
        for (int l : lost) {
            for (int i = 0; i < reserve.length; i++) {
                if (l == reserve[i]) {
                    answer++; // 주어진 여벌 체육복을 자신이 사용
                    reserve[i] = -1; // 처리된 여벌 체크
                    hasUniform[l] = true; // 해결된 상태 체크
                    break;
                }
            }
        }

        // 남은 잃어버린 학생들에 대한 처리
        for (int l : lost) {
            if (hasUniform[l]) continue; // 이미 처리된 학생은 건너뜀
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] != -1 && Math.abs(reserve[i] - l) == 1) {
                    answer++; // 체육수업을 들을 수 있는 학생 수 증가
                    reserve[i] = -1; // 처리된 여벌 체크
                    break;
                }
            }
        }
        
        return answer;
    }
}