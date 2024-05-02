import java.io.*;
import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int move = name.length()-1;
        for (int i=0; i<name.length(); i++){
            answer += Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A'));
            int e = i+1;
            while (e<name.length() && name.charAt(e)=='A'){
                e ++;
            }
            move = Math.min(move, i*2+(name.length()-e));
            move = Math.min(move, i+(name.length()-e)*2);
        }
        answer += move;
        return answer;
    }
}