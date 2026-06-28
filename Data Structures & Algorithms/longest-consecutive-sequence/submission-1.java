class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet <Integer>set = new HashSet<Integer>();
        for(int i: nums){
            set.add(i);
        }

        int max = 0;
        for(int num: set){    
            int count = 1;       
            if(!set.contains(num - 1)){
                int current = num;
                while(set.contains(current + 1)){
                    current++;
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
