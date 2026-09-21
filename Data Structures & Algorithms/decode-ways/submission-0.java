class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if(s.charAt(0)!='0'){
            dp[0] = 1;
        }
        
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(c!='0')
                dp[i] = dp[i-1];
            String last_2 = s.substring(i-1, i+1);
            // System.out.println(last_2 + " " + dp[i]);
            if(!last_2.startsWith("0")){
             if((i - 2)>= 0 && Integer.parseInt(last_2) <= 26){
                dp[i] += dp[i-2];
             }else if((i - 2) <=0 && Integer.parseInt(last_2) <= 26){
                dp[i] += 1;
             }
            }
        }

        return dp[s.length() - 1];
    }
}
