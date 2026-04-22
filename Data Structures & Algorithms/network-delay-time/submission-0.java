class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> g = new HashMap<>();
        
        for(int[] time:times) {
            int u_i = time[0];
            int v_i = time[1];
            int t_i = time[2];
            if(!g.containsKey(u_i)) {
                g.put(u_i, new ArrayList<>());
            }
            g.get(u_i).add(new int[]{v_i, t_i});
        }

        Queue<int[]> q = new LinkedList<>();
        int[] time_taken = new int[n + 1];
        for(int i=1;i<=n;i++){
            time_taken[i] = Integer.MAX_VALUE;
        }
        time_taken[k] = 0;
        q.add(new int[]{k, 0});
        while(!q.isEmpty()) {
            int[] top = q.poll();
            System.out.println(top[0] + " " + top[1]);
            int u_i = top[0];
            if(g.containsKey(u_i)) {
                for(int[] next: g.get(u_i)){
                    int time = top[1] + next[1];
                    if(time_taken[next[0]] > time) {
                        time_taken[next[0]] = time;
                        q.add(new int[]{next[0], time});
                    }
                }
            }
        }

        for(int t:time_taken) {
            if(t == Integer.MAX_VALUE) return -1;
        }

        int res = 0;
        for(int t:time_taken) {
            res = Math.max(res, t);
        }

        return res;
    }
}
