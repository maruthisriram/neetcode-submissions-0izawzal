class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(nums.length == 1) return dp[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2;i<nums.length - 1;i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int r_1 = dp[nums.length - 2];
        dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = Math.max(dp[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int r_2 = dp[nums.length - 1];
        return Math.max(r_1, r_2);
    }
}
