class Solution {
    int m,n;
    int [][]directions={{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        if(m==0 || n==0 || grid[0][0]==1){
            return -1;
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(0,0));
        grid[0][0]=1;
        int ans=0;

        while(!q.isEmpty()){
            int N=q.size();

            for(int i=0;i<N;i++){
                Pair curr=q.poll();

                int x=curr.first;
                int y=curr.second;

                if(x==m-1 && y==n-1){
                    return ans+1;
                }

                for(int []dir:directions){
                    int x_=x+dir[0];
                    int y_=y+dir[1];

                    if(isSafe(x_,y_) && grid[x_][y_]==0){
                        grid[x_][y_]=1;
                        q.offer(new Pair(x_,y_));
                    }
                }
            }
            ans+=1;
        }
        return -1;
    }

    private boolean isSafe(int x,int y){
        return x>=0 && y>=0 && x<m && y<n;
    }

    private class Pair{
        int first;
        int second;

        public Pair(int x,int y){
            this.first=x;
            this.second=y;
        }
    }
}