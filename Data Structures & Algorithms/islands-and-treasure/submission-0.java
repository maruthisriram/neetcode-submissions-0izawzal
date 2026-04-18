class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) {
                    q.add(new int[]{i, j, 0});
                    while(!q.isEmpty()){
                        int[] top = q.poll();
                        int x = top[0], y = top[1];
                        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
                        for (int[] dir : dirs) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];       
                            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] != -1 && grid[nx][ny]!=0) {
                                if((top[2] +  1) < grid[nx][ny]){
                                    q.add(new int[]{nx, ny, top[2] + 1});
                                    grid[nx][ny] = top[2] + 1; 
                                }
                            }
                        }
                    }   
                }
            }
        }
    }
}
