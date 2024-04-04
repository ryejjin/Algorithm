import java.io.*;
import java.util.*;

public class Main {
    static int n, d, k, c, ans;
    static int[] convey;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer  st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        convey = new int[n];

        for (int i=0; i<n; i++){
            convey[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d+1];
        int total = 0;

        for (int i=0; i<k; i++){
            if (sushi[convey[i]] == 0) total++;
            sushi[convey[i]]++;
        }
        if (sushi[c]==0) ans = total+1;
        else ans = total;

        for (int i=1; i<n; i++){
            if (ans <= total){
                if (sushi[c]==0) ans = total +1;
                else ans = total;
            }
            int left = i-1;
            sushi[convey[left%n]]--;
            if (sushi[convey[left%n]] == 0) total--;

            int right = (i+k-1)%n;
            if (sushi[convey[right]]==0) total++;
            sushi[convey[right]]++;

            if (sushi[c]==0 && ans<total+1){
                ans = total+1;
            }
        }
        System.out.println(ans);
    }
}