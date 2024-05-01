import java.io.*;
import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for (int i=0; i<answers.length; i++){
            int nowAnswer = answers[i];
            if (nowAnswer == one[i%5]) score[0]++;
            if (nowAnswer == two[i%8]) score[1]++;
            if (nowAnswer == three[i%10]) score[2]++;
        }
        int max = 0;
        max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<3; i++){
            if (max == score[i]){
                list.add(i+1);
            }
        }
        return list;
    }
}