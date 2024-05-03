import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = -1;
        int dfsAns = Integer.MAX_VALUE;
        int[][] info = new int[n+1][n+1];
        for (int i=0; i<wires.length; i++){
            info[wires[i][0]][wires[i][1]] = 1;
            info[wires[i][1]][wires[i][0]] = 1;
        }
        for (int i=0; i<wires.length; i++){
            info[wires[i][0]][wires[i][1]] = 0;
            info[wires[i][1]][wires[i][0]] = 0;
            
            // int d = sol(info,n);
            // System.out.println("*d "+d);
            dfsAns = Math.min(dfsAns,sol(info, n));
            // System.out.println("-dfsams "+dfsAns);
            
            info[wires[i][0]][wires[i][1]] = 1;
            info[wires[i][1]][wires[i][0]] = 1;
        }
        return Math.max(answer, dfsAns);
    }
    static int sol(int[][] info, int n){
        boolean[] visit = new boolean[n+1];
        List<Integer> elec = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        for (int i=1; i<n+1; i++){
            int temp = dfs(i, info, visit, n);
            elec.add(temp);
            System.out.print(temp+ " ");
        }
        Collections.sort(elec, Collections.reverseOrder());
        int tmp = Math.abs(elec.get(0)-elec.get(1));
        ans = Math.min(ans, tmp);
        System.out.println("*"+ans);
        return ans;
    }
    static int dfs(int i, int[][] info, boolean[] visit, int n){
        Stack<Integer> stack = new Stack<>();
        stack.add(i);
        visit[i] = true;
        int cnt = 0;
        while (!stack.isEmpty()){
            int k = stack.pop();
            for (int j=1; j<n+1; j++){
                if (info[k][j]==1 && !visit[j]){
                    stack.add(j);
                    visit[j] = true;
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}