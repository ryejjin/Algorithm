import java.io.*;
import java.util.*;

public class Main {
    static int n, k, max;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        // 각 원소가 몇 개 있는지 카운팅하는 배열
        int[] cnt = new int[100001];
        while (end<arr.length){
            while (end < arr.length && cnt[arr[end]]+1<=k){
                cnt[arr[end]]++;
                end++;
            }
            int len = end-start;
            max = Math.max(max, len);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(max);
    }
}