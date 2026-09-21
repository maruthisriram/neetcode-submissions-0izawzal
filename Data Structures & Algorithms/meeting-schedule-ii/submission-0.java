/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starting_times = new ArrayList<>();
        List<Integer> ending_times = new ArrayList<>();
        for(Interval interval:intervals){
            starting_times.add(interval.start);
            ending_times.add(interval.end);
        }
        Collections.sort(starting_times);
        Collections.sort(ending_times);
       int res = 0, count = 0, s = 0, e = 0;
       while(s < starting_times.size()){
            if(starting_times.get(s) < ending_times.get(e)){
                s++;
                count++;
            }else {
                e++;
                count--;
            }

            res = Math.max(res, count);
       }

        return res;
    }
}
