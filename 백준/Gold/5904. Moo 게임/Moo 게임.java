import java.io.*;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println(findMoo(n));

    }
    static char findMoo(int n){
        int length = 3; // 초기 문자의 길이
        int k = 0;
        // n을 찾기 위해 전체 길이 만들기
        while (n > length){
            k++;
            length = 2*length+(k+3);    // 다음 단계의 길이 (기존길이*2 + m + (o*(k+2))
        }

        while (k>0){
            int prev = (length-(k+3))/2;    //이전 단계의 길이
            if (n <= prev){
                length = prev;
            } else if (n > prev+(k+3)) {
                n -= prev + (k+3);
                length = prev;
            } else {
                if (n == prev+1){
                    return 'm';
                }else{
                    return 'o';
                }
            }
            k --;
        }
        if (n==1) return 'm';
        else return 'o';
    }
}