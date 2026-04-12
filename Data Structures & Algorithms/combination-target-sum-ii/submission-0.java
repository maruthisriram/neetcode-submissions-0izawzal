class Solution {
    private List<List<Integer>> subset = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates, 0,target, new ArrayList<>());
        return subset;
    }

    public void backTrack(int[] nums,int index, int target, List<Integer> currentSet){
        if(target==0){
            subset.add(new ArrayList<>(currentSet));

        }
        if(target > 0 && index < nums.length){
            for(int i=index;i<nums.length;i++){
                if(i > index && nums[i]==nums[i-1]) continue;
                currentSet.add(nums[i]);
                backTrack(nums, i + 1, target - nums[i], currentSet);
                currentSet.remove(currentSet.size() - 1);
            }
        }
    }
}
