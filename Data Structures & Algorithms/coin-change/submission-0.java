class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = amount + 1;
        }
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(coin <= i){
                    int current_coin = coin;
                    while(current_coin <= i) {
                        dp[i] = Math.min(dp[i], current_coin/coin + dp[i-current_coin]);
                                        // System.out.println(i+ " " + dp[i]);

                        current_coin += coin;
                    }
                }
                // System.out.println(i+ " " + dp[i]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
