class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for(char task: tasks){
            count[task - 'A']++;
        }

        int maxCount = 0;
        int maxFreq = 0;

        for(int i = 0; i < count.length; i++){
            if(count[i] > maxFreq){
                maxFreq = count[i];
                maxCount = 1;
            }else if(count[i] == maxFreq){
                maxCount++;
            }
        }

        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}
