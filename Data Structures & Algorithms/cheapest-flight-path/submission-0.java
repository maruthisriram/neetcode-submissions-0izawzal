
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. Build the adjacency list correctly
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            adj[flight[0]].add(new int[] { flight[1], flight[2] }); // {neighbor, price}
        }

        // 2. Track best distance for each city at a given stop count
        // dist[city][stops_used + 1]
        int[][] dist = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[src][0] = 0;

        // 3. Min-Heap sorted strictly by accumulated cost: {cost, city, stops_used}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { 0, src, -1 }); 

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int cost = top[0];
            int cur = top[1];
            int stops = top[2];

            // If we reached destination, it's guaranteed to be the cheapest valid path
            if (cur == dst) return cost;

            // If we hit the stop limit, we cannot make any further stops from here
            if (stops == k) continue;

            // Explore neighbors
            for (int[] next : adj[cur]) {
                int neighbor = next[0];
                int price = next[1];
                int nextCost = cost + price;
                int nextStops = stops + 1;

                // Optimization: Only push to PQ if this path is cheaper than 
                // any previous path found reaching 'neighbor' with this many stops
                if (nextCost < dist[neighbor][nextStops + 1]) {
                    dist[neighbor][nextStops + 1] = nextCost;
                    pq.offer(new int[] { nextCost, neighbor, nextStops });
                }
            }
        }

        return -1;
    }
}