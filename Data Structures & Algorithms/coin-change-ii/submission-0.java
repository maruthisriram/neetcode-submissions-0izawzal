class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i=0;i<=coins.length;i++) dp[i][0] = 1;
        for(int i=1;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                int currCoin = coins[i-1];
                dp[i][j] = dp[i - 1][j];
                while(currCoin <=j){
                    dp[i][j] += dp[i-1][j-currCoin];
                    currCoin+=coins[i-1];
                }
            }
        }

       return dp[coins.length][amount];
    }
}
