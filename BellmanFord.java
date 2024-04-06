public class BellmanFord {
    /*
     You will be given adjacency list of edges (u,v,w) where
     u->source node
     v-> dest. node
     w->cost or weight to reach that node

     use the following fuction to apply bellman ford algorithm
     */

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int []dist=new int[V];
        Arrays.fill(dist,100000000);
        dist[S]=0;
        
        for(int i=1;i<=V-1;i++){
            for(ArrayList<Integer> edge:edges){
                int u=edge.get(0);
                int v=edge.get(1);
                int w=edge.get(2);
                
                if(dist[u]!=100000000 && dist[u]+w<dist[v]){
                    dist[v]=w+dist[u];
                }
            }
        }
        for(ArrayList<Integer> edge:edges){
                int u=edge.get(0);
                int v=edge.get(1);
                int w=edge.get(2);
                
                if(dist[u]!=100000000 && dist[u]+w<dist[v]){
                   return new int[]{-1};
                }
            }
        

        return dist;
        
    }
}
