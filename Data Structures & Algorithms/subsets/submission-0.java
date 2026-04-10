class Solution {
    private List<List<Integer>> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0, new ArrayList<>());
        return subset;
    }

    private void backTrack(int[] nums, int index, List<Integer> currentSet){
        if(index<nums.length){
            backTrack(nums, index + 1, currentSet);
            currentSet.add(nums[index]);
            backTrack(nums, index+1, currentSet);
            currentSet.remove(currentSet.size() - 1);
        }
        if(index==nums.length){
            subset.add(new ArrayList<>(currentSet));
        }
    }
}
