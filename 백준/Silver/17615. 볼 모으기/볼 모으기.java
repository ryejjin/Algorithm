import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String info;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = br.readLine();

        int res = n;
        int red = 0; int blue = 0;
        for (int i=0; i<n; i++){
            if (info.charAt(i) == 'R'){
                red++;
            }else{
                blue++;
            }
        }
        int cnt = 0;
        for (int i=0; i<n; i++){
            if (info.charAt(i)=='R'){
                cnt++;
            }else{
                break;
            }
        }
        res = Math.min(res, red-cnt);

        cnt = 0;
        for (int i=n-1; i>=0; i--){
            if (info.charAt(i)=='R'){
                cnt++;
            }else{
                break;
            }
        }
        res = Math.min(res, red-cnt);

        cnt = 0;
        for (int i=0; i<n; i++){
            if (info.charAt(i)=='B'){
                cnt++;
            }else{
                break;
            }
        }
        res = Math.min(res, blue-cnt);

        cnt = 0;
        for (int i=n-1; i>=0; i--){
            if (info.charAt(i)=='B'){
                cnt++;
            }else{
                break;
            }
        }
        res = Math.min(res, blue-cnt);

        System.out.println(res);
    }
}