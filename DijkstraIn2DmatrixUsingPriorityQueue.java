class Solution {
    int m,n;
    int [][]directions={{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        if(m==0 || n==0 || grid[0][0]==1){
            return -1;
        }
        int [][]res=new int[m][n];

        for(int []arr:res){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.offer(new Pair(0,new Coordinate(0,0)));
        res[0][0]=0;


        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int d=curr.first;
            Coordinate node=curr.c;

            int x=node.x;
            int y=node.y;

            for(int []dir:directions){
                int x_=x+dir[0];
                int y_=y+dir[1];

                if(isSafe(x_,y_) && grid[x_][y_]==0 && d+1<res[x_][y_]){
                    pq.offer(new Pair(d+1,new Coordinate(x_,y_)));
                    res[x_][y_]=d+1;
                }
            }
        }

        if(res[m-1][n-1]==Integer.MAX_VALUE){
            return -1;
        }
        return res[m-1][n-1]+1;
    }

    private boolean isSafe(int x,int y){
        return x>=0 && y>=0 && x<m && y<n;
    }

    private class Pair implements Comparable<Pair>{
        int first;
        Coordinate c;

        public Pair(int x,Coordinate c){
            this.first=x;
            this.c=c;
        }

        public int compareTo(Pair p){
            return Integer.compare(this.first,p.first);
        }
    }

    private class Coordinate{
        int x;
        int y;
        public Coordinate(int x,int y){
            this.x=x;
            this.y=y;
        }


    }
}