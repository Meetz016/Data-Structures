
     // Write your code here
     int []res=new int[V];
     Arrays.fill(res,Integer.MAX_VALUE);
     res[S]=0;
     PriorityQueue<Pair> pq=new PriorityQueue<>();
     
     //cost,currNode
     pq.offer(new Pair(0,S));
     while(!pq.isEmpty()){
         Pair curr=pq.poll();
         
         int currCost=curr.key;
         int currNode=curr.val;
         
         //traverse each node from currNode
         for(ArrayList<Integer> list:adj.get(currNode)){
             int nextNode=list.get(0);
             int costTillHere=list.get(1);
             
             if(currCost+costTillHere<res[nextNode]){
                 res[nextNode]=currCost+costTillHere;
                 pq.offer(new Pair(currCost+costTillHere,nextNode));
             }
         }
         
     }
     return res;
 }
 
 static public class Pair implements Comparable<Pair>{
     int key;
     int val;
     
     public Pair(int x,int y){
         this.key=x;
         this.val=y;
     }
     
     public int compareTo(Pair p){
         return Integer.compare(this.key,p.key);
     }
 }
