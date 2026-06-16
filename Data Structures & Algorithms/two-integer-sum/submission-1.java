class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> n = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            n.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(n.containsKey(diff)){
               if(i != n.get(diff)){
                    return new int[]{i, n.get(diff)};
               } 
            }
        } 
        return new int[0];      
    }
}
