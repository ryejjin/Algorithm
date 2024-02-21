import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());

            String[] nums = new String[n];
            for (int i=0; i<n; i++){
                nums[i] = br.readLine();
            }
            Arrays.sort(nums);

            boolean isPossible = true;
            for (int j=1; j<n; j++){
                if (nums[j].startsWith(nums[j-1])){
                    isPossible = false;
                    break;
                }
            }
            if (!isPossible){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}