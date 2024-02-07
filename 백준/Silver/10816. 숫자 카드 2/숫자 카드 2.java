import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] cards;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        cards = new int[n];
        for (int i=0; i<n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            int lower = lowerNum(num);
            int upper = upperNum(num);

            sb.append(upper-lower).append(" ");
        }

        System.out.println(sb);


    }
    public static int lowerNum(int num){
        int start = 0;
        int end = cards.length;

        while (start<end){
            int mid = (start+end)/2;
            if (num <= cards[mid]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }

    public static int upperNum(int num){
        int start = 0;
        int end = cards.length;

        while (start<end){
            int mid = (start+end)/2;
            if (num < cards[mid]){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
}