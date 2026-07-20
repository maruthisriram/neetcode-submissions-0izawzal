class Solution {
    public int climbStairs(int n) {
        int a_1 = 1, a_2 = 2;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(n == 0) return 0;
        int a_i = -1;
        for(int i=3;i<=n;i++){
            a_i = a_1 + a_2;
            a_1 = a_2;
            a_2 = a_i;
        }
        return a_i;

    }
}
