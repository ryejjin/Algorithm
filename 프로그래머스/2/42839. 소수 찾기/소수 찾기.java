import java.io.*;
import java.util.*;

class Solution {
    static boolean[] chk;
    static HashSet<Integer> info = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        chk = new boolean[numbers.length()];
        for (int i=0; i<numbers.length(); i++){
            String temp = String.valueOf(numbers.charAt(i));
            chk[i] = true;
            makeNum(temp, chk, numbers);
            chk[i] = false;
        }
        for (Integer st: info){
            if (isPrimeNum(st)) answer++;
        }
        return answer;
    }
    static void makeNum(String s, boolean[] chk, String numbers){
        if (!info.contains(Integer.parseInt(s))) info.add(Integer.parseInt(s));
        for (int j=0; j<numbers.length(); j++){
            if (!chk[j]){
                chk[j] = true;
                makeNum(s+=numbers.charAt(j), chk, numbers);
                chk[j] = false;
                s = s.substring(0, s.length()-1);
            }
        }
    }
    static boolean isPrimeNum(int nb){
        if (nb <2) return false; // 0과 1은 소수가 아님
        if (nb == 2) return true; // 2는 소수임
        for (int x=2; x<nb; x++){
            if(nb%x==0) return false;
        }
        return true;
    }
}