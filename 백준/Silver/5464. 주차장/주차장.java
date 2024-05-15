import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ans;
    static int[] fees, weight, current;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fees = new int[n+1]; weight = new int[m+1];
        current = new int[n+1];
        for (int i=1; i<=n; i++){
            int rs = Integer.parseInt(br.readLine());
            fees[i] = rs;
        }
        for (int i=1; i<=m; i++){
            int wk = Integer.parseInt(br.readLine());
            weight[i] = wk;
        }
        Queue<Integer> q = new LinkedList<>();

        outer: for (int i=0; i<2*m; i++){
            int car = Integer.parseInt(br.readLine());

            if (car>0){
                for (int j=1; j<n+1; j++){
                    if (current[j] == 0){
                        current[j] = car;
                        continue outer;
                    }
                }
                q.offer(car);
            }else{
                car = (-1)*car;
                for (int j=1; j<n+1; j++){
                    if (current[j] == car){
                        current[j] = 0;
                        ans += fees[j]*weight[car];
                        if (!q.isEmpty()) current[j] = q.poll();
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}