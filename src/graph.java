import java.util.* ;
public class graph {
  private int n;
  private boolean directed;
  private List<List<Integer>> adj;

  graph(int n, boolean directed) {
    this.n = n;
    this.directed = directed;
    adj = new ArrayList<>();
    for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
  }

  void addEdge(int u, int v) {
    adj.get(u).add(v);
    if (!directed) adj.get(v).add(u);
  }


  void bfs ( int start ){
    boolean [] visited = new boolean[n];
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    while(!q.isEmpty()){
      int u = q.poll();
      visited[u]=true;
      System.out.println(u + " ");
      for(int v : adj.get(u)){
        if(!visited[v]){
          visited[v]= true;
          q.add(v);
        }
      }
    }
    System.out.println();
  }



  public static void main(String[] args) {
    graph g = new graph(6, false);

    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,3);
    g.addEdge(2,4);
    g.addEdge(3,4);

    g.bfs(0);


  }
}


