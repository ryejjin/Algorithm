import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] cost = new int[n][2];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int mass = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            cost[i] = new int[]{mass, price};
        }

        Arrays.sort(cost, new Comparator<int[]>() {
            @Override
            public int compare(int[] mass, int[] price) {
                if (Integer.compare(mass[1], price[1]) == 0) {
                    return Integer.compare(price[0], mass[0]);
                }
                return Integer.compare(mass[1], price[1]);
            }
        });

        int totalPrice = -1;
        int totalGram = 0;
        int ans = Integer.MAX_VALUE;
        boolean isPossible = false;

        for (int i=0; i<n; i++){
            totalGram += cost[i][0];

            if (i>0 && cost[i-1][1] == cost[i][1]){
                totalPrice += cost[i][1];
            } else {
                totalPrice = cost[i][1];
            }

            if (totalGram >= m){
                isPossible = true;
                ans = Math.min(ans, totalPrice);
            }
        }

        bw.write(isPossible ? ans + "\n" : -1 + "\n" );
        bw.flush();
        bw.close();
    }
}