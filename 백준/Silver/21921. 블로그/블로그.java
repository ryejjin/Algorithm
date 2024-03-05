import java.io.*;
import java.util.*;

public class Main {
    static int n, x, maxVisit, cnt;
    static int[] visit, dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visit = new int[n];
        dp = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            visit[i] = Integer.parseInt(st.nextToken());
            if (i==0){
                dp[i] = visit[i];
            }else dp[i] = dp[i-1]+visit[i];
        }

        int start = 0;
        int end = start+x-1;
        while (start<=n-x){
            if (end>n) break;
            int diff = dp[end]-dp[start]+visit[start];
//            System.out.println(start + " " + end + " " + diff);
            if (diff > maxVisit){
                maxVisit = diff;
                cnt = 1;
                start++;
                end++;
            } else if (diff == maxVisit) {
                cnt += 1; start++; end++;
            }else {
                start++;
                end++;
            }
        }
        System.out.println(maxVisit!=0? maxVisit+"\n"+cnt : "SAD");
    }
}