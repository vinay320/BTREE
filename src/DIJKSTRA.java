public class DIJKSTRA {
    public static final int V=9;

    int minDist(int[] dist,Boolean[] sptSet)
    {
        int min=Integer.MAX_VALUE;
        int min_index=-1;
        for (int i = 0; i < V; i++)
        {
            if(sptSet[i]==false && dist[i]<=min)
            {
                min=dist[i];
                min_index=i;
          }
        }
        return min_index;
    }

    void dijkstra(int[][] graph,int src)
    {
        int[] dist=new int[V];
        Boolean[] sptSet=new Boolean[V];
        for (int i = 0; i <V ; i++)
        {
            sptSet[i]=false;
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        for (int i = 0; i < V-1; i++)
        {
            int u=minDist(dist,sptSet);
            sptSet[u]=true;

            for (int j = 0; j <V ; j++) {
                if(sptSet[j]==false && graph[u][j]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][j]<dist[j])
                {
                    dist[j]=dist[u]+graph[u][j];
                }
            }
        }
        printdijkstra(dist);
    }

    static void printdijkstra(int[] dist)
    {
        for (int i = 0; i < V; i++) {
            System.out.println(i+"  "+dist[i]);
        }
    }

    public static void main(String[] args) {
        DIJKSTRA obj=new DIJKSTRA();
        int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        obj.dijkstra(graph,0);
    }
}
