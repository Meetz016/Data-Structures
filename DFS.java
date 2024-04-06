public void dfs(int node,ArrayList<ArrayList<Integer> adj,int []vis){
    vis[node]=1;

    for(int i:adj.get(node)){
        if(vis[i]==0){
            dfs(i,adj,vis);
        }
    }
}