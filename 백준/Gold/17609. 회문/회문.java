import java.io.*;

public class Main {
    static int t;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++){
            String input = br.readLine();
            System.out.println(palindrome(0, input.length()-1, input, 0));
        }
    }
    static int palindrome(int start, int end, String s, int chk){
        if (chk>=2) return 2;

        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return Math.min(palindrome(start+1, end, s, chk+1), palindrome(start, end-1, s, chk+1));
            }
        }
        return chk;
    }
}