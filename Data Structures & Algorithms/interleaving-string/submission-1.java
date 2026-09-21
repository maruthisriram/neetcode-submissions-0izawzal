class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        // Initialize first column (using only s1)
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        // Initialize first row (using only s2)
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        // Fill the rest of the DP table
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                char currentS3 = s3.charAt(i + j - 1);
                
                boolean fromS1 = dp[i - 1][j] && s1.charAt(i - 1) == currentS3;
                boolean fromS2 = dp[i][j - 1] && s2.charAt(j - 1) == currentS3;

                dp[i][j] = fromS1 || fromS2;
            }
        }

        return dp[s1.length()][s2.length()];
    }
}