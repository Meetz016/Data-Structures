//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        
        Stack<Integer> st=new Stack<>();
        int []visited=new int[V];
        Arrays.fill(visited,-1);
        
        //step-1
        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                dfsFill(i,adj,visited,st);
            }
        }
        
        
        //step-2
        ArrayList<ArrayList<Integer>> adjReverse=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjReverse.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            
            for(int v:adj.get(i)){
                adjReverse.get(v).add(i);
            }
        }
        
        //step-3 count components
        int c=0;
        Arrays.fill(visited,-1);
        
        while(!st.isEmpty()){
            int curr=st.pop();
            
            if(visited[curr]==-1){
                dfs(curr,adjReverse,visited);
                c++;
            }
        }
        return c;
        
    }
    
    public void dfs(int node,ArrayList<ArrayList<Integer>>adj,int []visited){
        visited[node]=1;
        
        for(int i:adj.get(node)){
            if(visited[i]==-1){
                dfs(i,adj,visited);
            }
        }
    }
    
    public void dfsFill(int node,ArrayList<ArrayList<Integer>> adj,int []vis,Stack<Integer> st){
        vis[node]=1;
        
        for(int i:adj.get(node)){
            if(vis[i]==-1){
                dfsFill(i,adj,vis,st);
            }
        }
        
        st.push(node);
    }
}
