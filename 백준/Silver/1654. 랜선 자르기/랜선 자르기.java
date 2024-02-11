import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[k];
        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        System.out.println(binarySearch());

    }
    public static long binarySearch(){
        long start = 1;
        long end = arr[arr.length-1];
        long mid, cnt;

        while (start<=end){
            mid = (start+end)/2;
            cnt = 0;

            for (int i=0; i<k; i++){
                cnt += arr[i]/mid;
            }

            if (cnt >= n){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return end;
    }
}