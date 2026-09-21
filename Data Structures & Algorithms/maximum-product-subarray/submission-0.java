class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1, curMax = 1;
        for(int num:nums) {
            int tmp = curMax * num;
            curMax = Math.max(num, Math.max(curMin * num, tmp));
            curMin = Math.min(num, Math.min(tmp, curMin * num));
            res = Math.max(res, curMax);
        }

        return res;
    }
}
