class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, target, 0, path, result);

        return result;
    }

    private void dfs(int[] nums, int remaining, int index, List<Integer> path, List<List<Integer>> result){
        if(remaining == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(remaining < 0 || index == nums.length){
            return;
        }

        path.add(nums[index]);

        dfs(nums, remaining - nums[index], index, path, result);

        path.remove(path.size() - 1);

        dfs(nums, remaining, index + 1, path, result);
    }

}


