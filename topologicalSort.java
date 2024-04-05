//using dfs


/*Complete the function below*/

    static Stack<Integer> st=new Stack<>();
    
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int []visited){
        visited[node]=1;
        
        for(int i:adj.get(node)){
            if(visited[i]==0){
                dfs(i,adj,visited);
            }
        }
        st.push(node);
    }
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        int []visited=new int[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,adj,visited);
            }
        }
        int index=0;
        while(!st.isEmpty()){
            visited[index]=st.pop();
            index++;
        }
        return visited;
        
    }

//using bfs    

        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
        {
            // step-1 find indegrees
    
            int []indeg=new int[V];
            
            for(ArrayList<Integer> l:adj){
                for(int i:l){
                    indeg[i]++;
                }
            }
            
            Queue<Integer> q=new LinkedList<>();
            //step-2 offer nodes with indegree 0
            
            for(int i=0;i<V;i++){
                if(indeg[i]==0){
                    q.offer(i);
                }
            }
            int[] topo=new int[V];
            int index=0;
            //simple bfs traversal
            
            while(!q.isEmpty()){
                int curr=q.poll();
                
                for(int i:adj.get(curr)){
                    indeg[i]--;
                    if(indeg[i]==0){
                        q.offer(i);
                    }
                }
                topo[index]=curr;
                index++;
            }
            
            return topo;
        }