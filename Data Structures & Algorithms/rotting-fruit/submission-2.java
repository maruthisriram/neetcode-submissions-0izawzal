class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i, j});
                }
            }
        }
        int res = 0;
        while(!q.isEmpty()){
            Queue<int[]> nextRound = new LinkedList<>();
            int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            while(!q.isEmpty()){
                int[] top = q.poll();
                int x = top[0];
                int y = top[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];       
                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny]==1) {
                        nextRound.add(new int[]{nx, ny});
                        grid[nx][ny] = 2; 
                    
                    }
                }
            }
            q = nextRound;
            res++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return res==0?res:res - 1;
    }
}
