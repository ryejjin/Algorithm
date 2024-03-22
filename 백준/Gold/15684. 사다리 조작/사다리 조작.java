import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h;
    static boolean[][] ladder;
    public static void main(String[] agrs) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        ladder = new boolean[h+1][n+1];
        if (m==0){
            System.out.println(0);
        }else{
            for (int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                ladder[a][b] = true;
            }
            for (int i=0; i<=3; i++){
                comb(1, 0, i);
            }
            System.out.println(-1);
        }
    }
    static void comb(int row, int cnt, int size){
        if (cnt == size){
            if (check()){
                System.out.println(size);
                System.exit(0);
            }
            return;
        }
        for (int r=row; r<=h; r++){
            for (int c=1; c<n; c++){
                if (ladder[r][c]) continue;
                if (ladder[r][c-1]) continue;
                if (ladder[r][c+1]) continue;
                ladder[r][c] = true;
                comb(r, cnt+1, size);
                ladder[r][c] = false;
            }
        }
    }
    static boolean check(){
        for (int i=1; i<=n; i++){
            int curPosition = i;
            int start = 1;
            while (start <= h){
                if (ladder[start][curPosition]){
                    curPosition++;
                    start++;
                } else if (ladder[start][curPosition-1]) {
                    curPosition--;
                    start++;
                }else {
                    start++;
                }
            }
            if (i!=curPosition){
                return false;
            }
        }
        return true;
    }
}