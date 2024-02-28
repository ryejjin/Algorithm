import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int x;
    int y;
    int cost;
    Node(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o){
        return cost - o.cost;
    }
}
public class Main {
    static int n, m;
    static int[] parents;
    static ArrayList<Node> info;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        info = new ArrayList<>();

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            info.add(new Node(a, b, c));
        }

        for (int i=0; i<n+1; i++){
            parents[i] = i;
        }

        Collections.sort(info);

        int ans = 0;
        int temp = 0;
        for (int i=0; i<info.size(); i++){
            Node node = info.get(i);

            if (find(node.x) != find(node.y)){
                ans += node.cost;
                union(node.x, node.y);

                temp = node.cost;
            }
        }

        bw.write((ans-temp) + "\n");
        bw.flush();;
        bw.close();;
    }
    public static int find(int x){
        if (x == parents[x]){
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x!=y){
            parents[y] = x;
        }
    }
}