import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for (int i=0; i<numbers.length; i++){
            num[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(num, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (num[0].equals("0")) {
           return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<num.length; i++){
            sb.append(num[i]);
        }
    
        return sb.toString();
    }
}