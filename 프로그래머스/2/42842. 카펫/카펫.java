import java.io.*;
import java.util.*;

class Solution {
    static class Node{
        int x; int y;
        Node(int x, int y){
            this.x = x; this.y = y;
        }
    }
    static List<Node> info = new ArrayList<>();
    public List<Integer> solution(int brown, int yellow) {
        List<Integer> answer = new ArrayList<>();
        findInfo(brown+yellow);
        for (Node node: info){
            if (node.x>=node.y){
                int temp = (node.x-1)*2 + (node.y-1)*2;
                if (temp == brown){
                    answer.add(node.x);
                    answer.add(node.y);
                }
            }
        }
        return answer;
    }
    static void findInfo(int num){
        for (int i=1; i<num; i++){
            if (num%i==0){
                info.add(new Node(i, num/i));
            }
        }
    }
}