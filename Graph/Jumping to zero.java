class Solution {
    public boolean canReach(int[] arr, int start) {
        
        boolean[] visited = new boolean[arr.length];
        
        return rec(start,arr,visited);
    }
    
    public boolean rec(int i, int[] arr, boolean[] visited){
        
        if(i<0 || i>=arr.length || visited[i])
            return false;
        
        visited[i] = true;
        
        if(arr[i]==0)
            return true;
        
        return (rec(i+arr[i],arr,visited) || rec(i-arr[i],arr,visited));
        
    }
}