import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k, sum, res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i=1; i<=k; i++){
            sum+=i;
        }
        n -= sum;
        if (n<0){
            res = -1;
        } else {
            if (n%k ==0){
                res = k-1;
            }else{
                res = k;
            }
        }
        System.out.println(res);
    }
}