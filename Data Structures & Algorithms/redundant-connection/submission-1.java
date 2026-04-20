class Solution {
    List<int[]> redundantEdges = new ArrayList<>();
    public int[] findRedundantConnection(int[][] edges) {
        Set<Integer> unique = new HashSet<>();
        for(int[] edge:edges){
            unique.add(edge[0]);
            unique.add(edge[1]);
        }
        UnionFind uf = new UnionFind(unique.size());
        for(int[] edge:edges){
            if(!uf.merge(edge[0], edge[1])) {
                redundantEdges.add(edge);
            }
        }

        return redundantEdges.get(redundantEdges.size() - 1);
    }
}


class UnionFind {
    int[] parent;
    int[] rank;
    public UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public boolean merge(int a, int b) {
        int p_a = find(a);
        int p_b = find(b);
        if(p_a==p_b) {
            return false;
        }

        if(rank[p_a] >= rank[p_b]) {
            parent[p_b] = parent[p_a];
            rank[a] += rank[p_b];
        }else{
            parent[p_a] = parent[p_b];
            rank[p_b] +=rank[p_a];
        }
        return true;
    }

    public int find(int a) {
        if(a!=parent[a]){
            a = find(parent[a]);
        }

        return parent[a];
    }
}