import java.util.*;

class Solution{

    /*
     * if you have been given array of edges then you have to convert them into this given adj list 
     * 
     * like this is for leetcode problem wehre i have converted the array into adj list
     * 
     * ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        int v=points.length;


        for(int i=0;i<v;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<v;i++){
            for(int j=i+1;j<v;j++){
                int x1=points[i][0];
                int y1=points[i][1];

                int x2=points[j][0];
                int y2=points[j][1];

                int dist=Math.abs(x1-x2)+Math.abs(y1-y2);

                adj.get(i).add(new int[]{j,dist});
                adj.get(j).add(new int[]{i,dist});
            }
        }
     */
    
    public int prims(ArrayList<ArrayList<int []>> adj,int V){
        int sum=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int []visited=new int[V];
        Arrays.fill(visited,-1);

        //here if you have been given a source node then you have to start from there
        // pair->(weight,node)
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair curr=pq.poll();

            int wt=curr.wt;
            int node=curr.node;

            if(visited[node]!=-1){
                continue;
                //already visited
            }
            visited[node]=1;
            sum+=wt;

            for(int []arr:adj.get(node)){
                int neighbour=arr[0];
                int neighbour_wt=arr[1];

                if(visited[neighbour]==-1){
                    pq.offer(new Pair(neighbour_wt, neighbour));
                }
            }
        }

        return sum;
    }
}

class Pair implements Comparable<Pair>{
    int wt;
    int node;

    public Pair(int x,int y){
        this.wt=x;
        this.node=y;
    }

    public int compareTo(Pair other){
        return Integer.compare(this.wt, other.wt);
    }
}