class Solution {
    
    class Pair{
        int i,j;
        
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
        
    public String toString() { 
        return "("+this.i +"," + this.j+")"; 
    } 
}
    
    public int orangesRotting(int[][] grid) {
        if(grid.length==0)
            return -1;
        
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2)
                    q.add(new Solution().new Pair(i,j));
                else if(grid[i][j]==1)
                    fresh+=1;
            }
        }
        //System.out.println(fresh);
        //System.out.println(q);
        
        
        if(fresh==0)
            return 0;
        
        if(q.isEmpty())
            return -1;
        
        int rotten = 0;
        int time = 0;
        Boolean rotHua = false;
         Queue<Pair> q_rot = new LinkedList<>();
        
        while(!q.isEmpty() || !q_rot.isEmpty()){
        //System.out.println(q);
          //  System.out.println(q_rot);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int i = curr.i;
            int j = curr.j;
            rotHua = false;
            
            
            if(isValid(i,j+1,grid)){
                grid[i][j+1]=2;
                q_rot.add(new Solution().new Pair(i,j+1));
                rotten+=1;
            }
            
            if(isValid(i+1,j,grid)){
                grid[i+1][j]=2;
                q_rot.add(new Solution().new Pair(i+1,j));
                rotten+=1;
            }
            
            
            if(isValid(i-1,j,grid)){
                grid[i-1][j]=2;
                q_rot.add(new Solution().new Pair(i-1,j));
                rotten+=1;
            }
            
            
            if(isValid(i,j-1,grid)){
                grid[i][j-1]=2;
                q_rot.add(new Solution().new Pair(i,j-1));
                rotten+=1;
            }
                
            
        }
            time+=1;
            q = q_rot;
            q_rot = new LinkedList<>();
        }
        if(rotten!=fresh)
            return -1;
        else
            return time-1;
    }
    
    public Boolean isValid(int i, int j, int[][] grid){
        if(i<0 ||j<0||i>=grid.length||j>=grid[0].length || grid[i][j]==0 || grid[i][j]==2)
            return false;
        else
            return true;
}
}