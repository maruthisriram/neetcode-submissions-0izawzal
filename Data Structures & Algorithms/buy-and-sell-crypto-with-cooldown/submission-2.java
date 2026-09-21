class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for(int i=1;i<prices.length;i++){
            if(i==1){
                dp[i][0] = Math.max(-prices[i], -prices[i-1]);
                dp[i][1] = Math.max(prices[i] + dp[i-1][0], dp[i-1][1]);
            }else{
                dp[i][0] = Math.max(-prices[i] + dp[i-2][1], dp[i-1][0]);
                dp[i][1] = Math.max(prices[i] + dp[i-2][0], Math.max(prices[i] + dp[i-1][0], dp[i-1][1]));
            }
        }

        return dp[prices.length - 1][1];
    }
}
