import java.io.*;
import java.util.*; 
class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i=0; i<n; i++){
            parent[i] = i;
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (computers[i][j] == 1){
                    union(parent, i, j);
                }
            }
        }
        for (int i=0; i<n; i++){
            find(parent, i);
        }
        HashSet<Integer> answer = new HashSet<>();
        for (int i=0; i<n; i++){
            answer.add(parent[i]);
        }
        return answer.size();
    }
    static void union(int[] parent, int i, int j){
        int a = find(parent, i);
        int b = find(parent, j);
        if (a<b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
    static int find(int[] parent, int x){
        if (parent[x]!=x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}