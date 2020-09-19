// DFS Approach

class Solution {
    
    
    public int maxAreaOfIsland(int[][] grid) {
        
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1)
                    ans = Math.max(ans,dfs_util(i,j,grid));
            }
        }
        
        return ans;
        
    }
    
    public int dfs_util(int i, int j, int[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==0)
            return 0;
        
        grid[i][j] = 0;
        
        int curr = 1;
        curr += dfs_util(i+1,j,grid);
        curr += dfs_util(i,j+1,grid);
        curr += dfs_util(i-1,j,grid);
        curr += dfs_util(i,j-1,grid);
        return curr;
    }
}