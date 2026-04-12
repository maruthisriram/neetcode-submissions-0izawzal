class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> indexes = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            indexes.add(i);
        }
        backTrack(nums, indexes, new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, List<Integer> remainingIndex, List<Integer> currentSet) {
        if(currentSet.size()==nums.length) {
            res.add(new ArrayList<>(currentSet));
        }else{
            for(int i=0;i<remainingIndex.size();i++){
                int index = remainingIndex.get(i);
                currentSet.add(nums[index]);
                remainingIndex.remove(i);
                backTrack(nums, remainingIndex, currentSet);
                remainingIndex.add(i, index);
                currentSet.remove(currentSet.size() - 1);

            }
        }
    }
}
