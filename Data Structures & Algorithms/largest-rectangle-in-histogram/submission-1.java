class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int index = stack.pop();
                int h = heights[index];
                int width;

                if(stack.isEmpty()){
                    width = i;
                }else{
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, h * width);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            int h = heights[index];
            int width;

            if(stack.isEmpty()){
                width = heights.length;
            }else{
                width = heights.length - stack.peek() - 1 ;
            }

            maxArea = Math.max(maxArea, h * width);
        }
        return maxArea;
    }
}
