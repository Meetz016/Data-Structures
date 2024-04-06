 class WarshallFloydd {
    public void shortest_distance(int[][] matrix)
    {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=100000000;
                }
            }
        }
        
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }
        
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==100000000){
                    matrix[i][j]=-1;
                }
            }
        }
    }
}
