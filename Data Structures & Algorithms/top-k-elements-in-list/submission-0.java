class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = freq.length - 1; i >= 0; i--){
            for(int j = 0; j < freq[i].size(); j++){
                int num = freq[i].get(j);

                result[index] = num;
                index++;
                k--;

                if(k == 0){
                    return result;
                }
            }
        }      
        return result;
    }
}
