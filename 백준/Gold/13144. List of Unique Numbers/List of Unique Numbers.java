import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long ans;
    static int[] arr, cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        cnt = new int[100001];
        for (int i=1; i<n+1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        int end = 0;
        while (start <= n){
            while (end+1 <= n && cnt[arr[end+1]]==0){
                end ++;
                cnt[arr[end]]++;
            }
            ans += end-start+1;
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(ans);
    }
}