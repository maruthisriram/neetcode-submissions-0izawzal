class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] p:prerequisites){
            if(!graph.containsKey(p[0])){
                graph.put(p[0], new ArrayList<>());
            }
            graph.get(p[0]).add(p[1]);
            indegree[p[1]] += 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) {
                q.add(i);
            }
        }
        if(q.isEmpty()) return false;
        while(!q.isEmpty()){
            int top = q.poll();
            if(graph.containsKey(top)){
                for(int next:graph.get(top)) {
                    indegree[next] -=1;
                    if(indegree[next]==0){
                        q.add(next);
                    }
                }
            }
        }
        for(int degree:indegree){
            if(degree!=0) return false;
        }
        return true;

    }
}
