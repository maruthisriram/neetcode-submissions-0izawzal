class Solution {
    public int trap(int[] height) {
        int[] prefixMaximum = new int[height.length];
        int[] suffixMaximum = new int[height.length];
         int n = height.length;
        if (n == 0) {
            return 0;
        }
        prefixMaximum[0] = height[0];
        suffixMaximum[height.length - 1] = height[height.length - 1];
        for(int i=1;i<height.length;i++){
            prefixMaximum[i] = Math.max(prefixMaximum[i - 1], height[i]);
        }
        for(int i=height.length - 2;i>=0;i--){
            suffixMaximum[i] = Math.max(suffixMaximum[i + 1], height[i]);
        }
        int res = 0;
        for(int i=0;i < height.length;i++){
            res += Math.min(prefixMaximum[i], suffixMaximum[i]) - height[i];
        }
        return res;
    }
}
