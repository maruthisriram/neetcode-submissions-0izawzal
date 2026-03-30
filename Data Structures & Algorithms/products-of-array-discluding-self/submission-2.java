class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int product_without_zero = 1;
        int num_zeroes = 0;
        boolean found = false;
        for(int num:nums){
            product = product * num;
            if(num!=0){
                 found = true;
                 product_without_zero = product_without_zero * num;
            }else{
                 num_zeroes++;
            }
        }
        if(!found || num_zeroes > 1) {
            int[] res = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                res[i] = 0;
            }
            return res;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) nums[i] = product_without_zero;
            else nums[i] = product/nums[i];
        }
        return nums;
    }
}  
