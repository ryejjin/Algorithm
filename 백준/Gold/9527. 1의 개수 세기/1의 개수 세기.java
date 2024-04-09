import java.io.*;
import java.util.*;

public class Main {
    static long a, b;
    static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dp = new long[55];
        dp[0] = 1;
        for (int i=1; i<55; i++){
            dp[i] = (dp[i-1]<<1) + (1L<<i);
        }

        long res = cal(b) - cal(a-1);
        System.out.println(res);
    }
    static long cal(long x){
        long cnt = x&1;
        int size = (int)(Math.log(x)/Math.log(2));
        for (int i=size; i>0; i--){
            if ((x&(1L<<i)) != 0L){
                cnt += dp[i-1]+(x-(1L<<i)+1);
                x -= (1L<<i);
            }
        }
        return cnt;
    }
}