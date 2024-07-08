import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, ans;
    static int[][] arr;
    static boolean[][][] visit;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static class Node{
        int x; int y;
        int cnt;
        int dist;
        Node(int x, int y, int cnt, int dist){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m][k+1];
        ans = -1;
        for (int i=0; i<n; i++){
            String input = br.readLine();
            for (int j=0; j<m; j++){
                arr[i][j] = input.charAt(j)-'0';
            }
        }
        bfs();

        System.out.println(ans);

    }
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 1));
        visit[0][0][0] = true;

        while (!q.isEmpty()){
            Node node = q.poll();
            if (node.x==n-1 && node.y==m-1){
                ans = node.dist;
                return;
            }
            for (int w=0; w<4; w++){
                int nx = node.x+dx[w];
                int ny = node.y+dy[w];
                if (!isPossible(nx, ny)) continue;

                if (arr[nx][ny]==0 && !visit[nx][ny][node.cnt]){
                    visit[nx][ny][node.cnt] = true;
                    q.add(new Node(nx, ny, node.cnt, node.dist+1));
                }else{
                    if (node.cnt<k && !visit[nx][ny][node.cnt+1]){
                        visit[nx][ny][node.cnt+1] = true;
                        q.add(new Node(nx, ny, node.cnt+1, node.dist+1));
                    }
                }
            }
        }

    }
    static boolean isPossible(int x, int y){
        if (0<=x && x<n && 0<= y && y<m) return true;
        return false;
    }
}
