import java.io.*;
import java.util.*;

public class Main {
    static int T, n;
    static List<String> ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            n = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(1, 1, 0, 1, "1");
            System.out.println(sb);

        }
    }
    static void dfs(int idx, int num, int sum, int op, String express){
        if (idx == n){
            sum += (num*op);
            if (sum == 0) sb.append(express+"\n");
            return;
        }
        dfs(idx+1, num*10+(idx+1), sum, op, express+" "+Integer.toString(idx+1));
        dfs(idx+1, idx+1, sum+(num*op), 1, express+"+"+Integer.toString(idx+1));
        dfs(idx+1, idx+1, sum+(num*op), -1, express+"-"+Integer.toString(idx+1));
    }
}