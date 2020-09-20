// Using DFS recursion

class Solution {
    public int numIslands(char[][] grid) {
        
        int r = grid.length;
        if(r==0)
            return 0;
        int c = grid[0].length;
        if(c==0)
            return 0;
        
        int ans = 0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]=='1'){
                    ans+=1;
                    dfs_helper(i,j,grid);
                }
            }
        }
        return ans;
        
    }
    
    public void dfs_helper(int i, int j, char[][] grid){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
            return;
        grid[i][j] = '0';
        
        dfs_helper(i+1,j,grid);
        dfs_helper(i-1,j,grid);
        dfs_helper(i,j+1,grid);
        dfs_helper(i,j-1,grid);
    }
    
    
}