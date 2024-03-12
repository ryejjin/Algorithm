import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr, ans;
    static class Node{
        int idx;
        int height;
        Node(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++){
            int h = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()){
                sb.append(0+" ");
                stack.add(new Node(i, h));
            }else{
                while (true){
                    if (stack.isEmpty()){
                        sb.append(0+" ");
                        stack.push(new Node(i, h));
                        break;
                    }
                    Node node = stack.peek();
                    if (h<node.height){
                        sb.append(node.idx+" ");
                        stack.push(new Node(i, h));
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}