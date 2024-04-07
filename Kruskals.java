import java.util.Comparator;
import java.util.PriorityQueue;

class Solution{


    static int []rank;
    static int []parent;

    static private void union(int x,int y){
        int u=find(x);
        int v=find(y);

        if(u==v){
            return;
        }

        if(rank[u]>rank[v]){
            parent[v]=u;
        }else if(rank[v]>rank[u]){
            parent[u]=v;
        }else{
            parent[u]=v;
            rank[v]+=1;
        }
    }
    static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    static private int kruskals(int V,int e,int [][]adj){
        parent=new int[V];
        rank=new int[V];
        int sum=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        for(int []arr:adj){
            pq.offer(arr);
        }

        while(!pq.isEmpty()){
            int []crr=pq.poll();

            int u=crr[0];
            int v=crr[1];
            int w=crr[2];

            if(find(u)!=find(v)){
                union(u, v);
                sum+=w;
            }
        }

        return sum;
    }
}