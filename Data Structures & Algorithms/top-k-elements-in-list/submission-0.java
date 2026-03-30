class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(int num:nums){
            if(!maxHeap.contains(num)) maxHeap.add(num);
        }

        int[] res = new int[k];
        int i = 0;
        while(!maxHeap.isEmpty() && i < k){
            res[i] = maxHeap.poll();
            i++;
        }

        return res;
        
    }
}
