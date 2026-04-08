class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                return (int) (Math.pow(a[0], 2) + Math.pow(a[1], 2)) - (int) (Math.pow(b[0], 2) + Math.pow(b[1], 2));
            }
        });

        for(int[] point:points){
            pq.add(point);
        }
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            res[i] = pq.poll();
        }
        return res;

    }
}
