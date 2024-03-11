import java.io.*;
import java.util.*;

public class Main {
    static int n, k, ans;
    static String[] input;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        input = br.readLine().split("");
        for (int i=0; i<n; i++){
            if (input[i].equals("P")){
                for (int j=i-k; j<=i+k; j++){
                    if (j<0 || j>=n) continue;
//                    System.out.println(i+":"+input[i]+" " + j+": "+input[j]);
                    if (input[j].equals("H")){
                        input[j] = "A";
                        ans ++;
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}