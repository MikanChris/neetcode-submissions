class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int maxi = 0;
        
        while (left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            maxi = Math.max(maxi, area);
            if(heights[left] < heights[right]){
                left++;
            }else if(heights[left] > heights[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }

        return maxi;
    }
}
