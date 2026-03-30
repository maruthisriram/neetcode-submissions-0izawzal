class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> nums[b] - nums[a]);
        int[] res = new int[nums.length - k + 1];
        for(int i=0;i<k;i++){
            maxHeap.add(i);
        }
        res[0] = nums[maxHeap.peek()];
        for(int i=k;i<nums.length;i++){
            maxHeap.remove(i - k);
            maxHeap.add(i);
            res[i -k + 1] = nums[maxHeap.peek()];
        }

        return res;
    }
}
