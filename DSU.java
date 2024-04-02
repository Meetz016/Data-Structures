// code for DSU find and union function



int []parent;
    int []rank;
    private int find(int i){
        if(i==parent[i]){
            return i;
        }

        return parent[i]=find(parent[i]);
    }

    private void union(int x,int y){
        int x_parent=find(x);
        int y_parent=find(y);

        if(x_parent==y_parent){
            return;
        }
        if(rank[x_parent]>rank[y_parent]){
            parent[y_parent]=x_parent;
        }else if(rank[y_parent]>rank[x_parent]){
            parent[x_parent]=y_parent;
        }else{
            parent[x_parent]=y_parent;
            rank[y_parent]++;
        }
    }