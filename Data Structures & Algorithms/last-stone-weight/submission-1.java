class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(stones.length == 1) return stones[0];
        for(int stone:stones){
            pq.add(stone);
        }

        while(pq.size() > 1) {
            int stone_1 = pq.poll();
            int stone_2 = pq.poll();
            if(stone_1 > stone_2){
                pq.add(stone_1 - stone_2);
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
}
