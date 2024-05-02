class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        //int answer = 0;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    static void dfs(int[] numbers, int target, int idx, int cals){
        if (cals==target && idx==numbers.length){
            answer++;
        }
        if(idx<numbers.length){
            int f = cals-numbers[idx];
            int p = cals+numbers[idx];
            idx++;
            //System.out.println(idx+" "+f+" "+p);
            dfs(numbers, target, idx, f);
            dfs(numbers, target, idx, p);
        }
    }
}