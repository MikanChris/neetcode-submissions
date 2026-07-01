class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left = 0;
        int right = numbers.length - 1;
        int sum = numbers[left] + numbers[right];
        int[] ans = new int[2];
        
        while(sum != target){
            if(sum < target){
                left++;
            }
            if(sum > target){
                right--;
            }
            sum = numbers[left] + numbers[right];
        }
        ans[0] = left+1;
        ans[1] = right+1;
        return ans;
    }
}
