class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Boolean> freq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(freq.getOrDefault(nums[i], false)) return true;
            freq.put(nums[i], true);
        }

        return false;
    }
}