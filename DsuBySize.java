class DsuBySize {


    int []parent;
    int []size;
    public int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }

    public void unionBySize(int x,int y){
        int u=find(x); //x-parent
        int v=find(y); //y-parent

        if(u==v){
            return;
        }

        if(size[u]>size[v]){
            parent[v]=u;
            size[u]+=size[v];
        }else if(size[v]>size[u]){
            parent[u]=v;
            size[v]+=size[u];
        }else{
            parent[u]=v;
            size[v]+=size[u];
        }
    }
}
