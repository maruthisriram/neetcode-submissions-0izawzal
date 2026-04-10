class Solution {
    private List<List<Integer>> subset = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backTrack(nums, 0,target, new ArrayList<>());
        return subset;
    }
    public void backTrack(int[] nums, int index, int target, List<Integer> currentSet){
        if(target==0){
            subset.add(new ArrayList<>(currentSet));

        }
        if(target > 0 && index < nums.length){
                int num = nums[index];
                if((target - num) >= 0) {
                    currentSet.add(num);
                    backTrack(nums, index, target-num,  currentSet);
                    currentSet.remove(currentSet.size() - 1);
                }
                backTrack(nums, index + 1, target,  currentSet);
                   
        }
    }
}
