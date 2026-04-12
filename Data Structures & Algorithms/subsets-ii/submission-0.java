class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int index, List<Integer> currentSet){
        res.add(new ArrayList<>(currentSet));
        
            for(int i = index;i<nums.length;i++){
                if(i!=index && nums[i]==nums[i-1]){
                    continue;
                }
                currentSet.add(nums[i]);
                    backTrack(nums, i + 1, currentSet);
                    currentSet.remove(currentSet.size() - 1);
                
            }
    }
}
