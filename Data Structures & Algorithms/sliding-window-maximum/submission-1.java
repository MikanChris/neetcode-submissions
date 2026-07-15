class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;
        int[] answer = new int[nums.length - k + 1];

        for(int right = 0; right < nums.length; right++){
            
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.offerLast(right);
            
            if(deque.peekFirst() < left){
                deque.pollFirst();
            }
            
            if(right - left + 1 == k){
                answer[left] = nums[deque.peekFirst()];
                left++;
            }
        }

        return answer;
    }
}
