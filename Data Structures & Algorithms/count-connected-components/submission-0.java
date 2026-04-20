class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            if(!graph.containsKey(edge[0])) {
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);
            
            if(!graph.containsKey(edge[1])) {
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int res = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                 q.add(i);
                 res++;
                 while(!q.isEmpty()) {
                int top = q.poll();
                visited[top] = true;
                if(graph.containsKey(top)) {
                    for(int next:graph.get(top)) {
                        if(!visited[next]) {
                            q.add(next);
                        }
                    }
                }
            }
            }
            
        }
        return res;
    }
}
