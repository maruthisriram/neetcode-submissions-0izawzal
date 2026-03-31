class Solution {
    public int search(int[] nums, int target) {
        int l =0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[l] <= nums[mid]){
                if(target>=nums[l] && target<=nums[mid]){
                    if(nums[mid]==target) return mid;
                    if(nums[mid] < target) l = mid + 1;
                    if(nums[mid] > target) r= mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            if(nums[r] > nums[mid]) {
                if(target >= nums[mid] && target <=nums[r]){
                    if(nums[mid]==target) return mid;
                    if(nums[mid] < target) l = mid + 1;
                    if(nums[mid] > target) r= mid - 1;
                }else{
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
