import java.io.*;
import java.util.*;

public class Main {
    static int n, w, l, time;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        Queue<Integer> arr = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<w; i++){
            q.add(0);
        }

        int weight = 0;
        while (!q.isEmpty()){
            time += 1;
            weight -= q.poll();

            if (!arr.isEmpty()){
                if (arr.peek()+weight <= l){
                    weight+=arr.peek();
                    q.add(arr.poll());
                }else{
                    q.add(0);
                }
            }
        }
        System.out.println(time);
    }
}