import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] graph = new int[101][101];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;

            ArrayList<Integer> curve = new ArrayList<Integer>();
            curve.add(d);
            for (int j=0; j<g; j++){
                for (int k=curve.size()-1; k>-1; k--){
                    curve.add((curve.get(k) +1)%4);
                }
            }

            for (int w=0; w<curve.size(); w++){
                x += dx[curve.get(w)];
                y += dy[curve.get(w)];
                if (x<0 || x>=101 || y<0 || y>=101){
                    continue;
                }
                graph[x][y] = 1;
            }
        }

        int res = 0;

        for (int i=0; i<100; i++){
            for (int j=0; j<100; j++){
                if (graph[i][j] == 1 && graph[i+1][j] == 1 && graph[i][j+1] == 1 && graph[i+1][j+1] == 1){
                    res += 1;
                }
            }
        }
        System.out.println(res);
    }
}