import java.io.*;
import java.util.*;

public class Main {
    static int T, k;
    static String w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            w = br.readLine();
            k = Integer.parseInt(br.readLine());
            
            if (k==1){
                System.out.println("1 1");
                continue;
            }
            
            // 알파벳 갯수 저장
            int[] alpha = new int[26];
            for (int i=0; i<w.length(); i++){
                alpha[w.charAt(i) - 'a']++;
            }
            
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i=0; i<w.length(); i++){
                if (alpha[w.charAt(i)-'a'] < k) continue;
                
                int cnt = 1;
                for (int j=i+1; j<w.length(); j++){
                    if (w.charAt(i) == w.charAt(j)) cnt ++;
                    if (cnt == k){
                        min = Math.min(min, j-i+1);
                        max = Math.max(max, j-i+1);
                        break;
                    }
                }
            }
            if (min==Integer.MAX_VALUE||max==Integer.MIN_VALUE) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}