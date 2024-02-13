import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int t, n;
    static int[] stock;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            stock = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                stock[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            long ans = 0;
            for (int k=n-1; k>=0; k--){
                if (stock[k] > max){
                    max = stock[k];
                } else {
                    ans += max-stock[k];
                }
            }
            System.out.println(ans);

        }
    }
}