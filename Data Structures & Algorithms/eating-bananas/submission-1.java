class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE, min = 1;
        for(int pile:piles){
            max = Math.max(pile, max);
        }
        int mid = 0, res = 0;
        while(min<=max){
            mid = (min + max)/2;
            int time = 0;
            for(int pile:piles){
                time += (int) Math.ceil(pile/(double) mid);
            }
            System.out.println(min + " " + mid + " " + max + " " + time);
            if(time > h) min = mid + 1;
            if(time <= h){
                 res = mid;
                 max = mid - 1;
            }
        }
        return res;
    }
}
