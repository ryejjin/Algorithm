import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        for (int i=0; i<n+1; i++){
            int cnt = 0; int tnc = 0;
            for (int j=0; j<n; j++){
                //System.out.println(i+" "+j+" "+citations[j]);
                if (i<=citations[j]) cnt++;
                else if (i>=citations[j]) tnc++;
            }
            if (cnt >= i && tnc <= i){
                answer = Math.max(answer, i);
            }
        }
        return answer;
    }
}