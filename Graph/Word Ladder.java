class Solution {
    
    class Graph{
        HashMap<String,ArrayList<String>> g;
        
        Graph(){
            this.g = new HashMap<>();
        }
        
        public void addEdge(String u, String v){
            ArrayList<String> arr;
            if(this.g.containsKey(u))
                arr = this.g.get(u);
            else
                arr = new ArrayList<>();
            
            arr.add(v);
            this.g.put(u,arr);
            
            if(this.g.containsKey(v))
                arr = this.g.get(v);
            else
                arr = new ArrayList<>();
            
            arr.add(u);
            this.g.put(v,arr);
        }
        
        public void display(){
            for(String k : this.g.keySet()){
                System.out.print(k+" -> ");
                for(String w : this.g.get(k)){
                    System.out.print(w+" -> ");
                }
                System.out.println();
            }
        }
        
        public int getDist(String begin,String end){
            
            HashMap<String,Boolean> visited = new HashMap<>();
            HashMap<String, Integer> dist = new HashMap<>();
            for(String k : this.g.keySet())
                visited.put(k,false);
            
            
            Queue<String> q = new LinkedList<>();
            q.add(begin);
            visited.put(begin,true);
            dist.put(begin,1);
            
            while(!q.isEmpty()){
                //System.out.println(q);
                String curr = q.poll();
                int d = dist.get(curr);
                
                if(this.g.containsKey(curr)){
                    for(String c : this.g.get(curr)){
                        
                        if(c.equals(end))
                            return d+1;
                        
                        if(!visited.containsKey(c) || !visited.get(c)){
                            q.add(c);
                            visited.put(c,true);
                            dist.put(c,d+1);
                        }
                    }
                }
                
            }
            
            return 0;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       
        
        Graph g = new Solution().new Graph();
        
        if(!wordList.contains(endWord))
            return 0;
        
        wordList.add(beginWord);
        
        int n = wordList.size();
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(oneWordDiff(wordList.get(i),wordList.get(j)))
                    g.addEdge(wordList.get(i),wordList.get(j));
            }
        }
        
        //g.display();
        int ans = g.getDist(beginWord,endWord);
        return ans;
    }
    
    public boolean oneWordDiff(String a, String b){
        
        if(a.length() != b.length())
            return false;
        
        int n = a.length();
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(a.charAt(i)!=b.charAt(i))
                cnt+=1;
            
            if(cnt==2)
                return false;
        }
        return true;
    }
}