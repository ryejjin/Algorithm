class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    static void dfs(int[] numbers, int target, int idx, int cals){
        if (cals==target && idx==numbers.length){
            answer++;
        }
        if(idx<numbers.length){
            //int f = cals-numbers[idx];
            //int p = cals+numbers[idx];
            //idx++;
            dfs(numbers, target, idx+1, cals-numbers[idx]);
            dfs(numbers, target, idx+1, cals+numbers[idx]);
        }
    }
}