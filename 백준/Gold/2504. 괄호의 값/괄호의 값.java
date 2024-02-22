import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int res = 0;
        int value = 1;

        for (int i=0; i<input.length(); i++){
            char c = input.charAt(i);

            if (c == '('){
                stack.push(c);
                value *= 2;
            } else if (c == '[') {
                stack.push(c);
                value *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '('){
                    res = 0;
                    break;
                } else if (input.charAt(i-1) == '(') {
                    res += value;
                }
                stack.pop();
                value /= 2;
            } else if (c == ']'){
                if (stack.isEmpty() || stack.peek() != '['){
                    res = 0;
                    break;
                } else if (input.charAt(i-1) == '['){
                    res += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if (!stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(res);
        }
    }
}