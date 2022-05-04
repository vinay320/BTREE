import java.util.Scanner;
class Edge1
{
    int src,dest,weight;
    Edge1()
    {
        src=dest=weight=0;
    }
}
public class Bellman {

    int V,E;
    Edge1[] edge;
    Bellman(int v,int e)
    {
        V=v;
        E=e;
        edge=new Edge1[e];
        for (int i = 0; i <e; i++)
        {
            edge[i]=new Edge1();
        }
    }
    void Bellmanford(Bellman graph,int src) {
        int V = graph.V, E = graph.E;
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    System.out.println("Graph contains negative cycle");
                    return;
                }
            }
            printARR(dist,V);
        }

       static void printARR(int[] dist,int V ){
        System.out.println("Vertex distance from src");
        for (int i = 0; i <V ; i++)
        {
            System.out.println(i+"\t\t"+dist[i]);
        }
        }

    public static void main(String[] args) {
        int V=5;
        int E=8;
        Bellman graph=new Bellman(V,E);
        Scanner sc=new Scanner(System.in);
        for (int i = 0; i <E ; i++)
        {
            graph.edge[i].src=sc.nextInt();
            graph.edge[i].dest=sc.nextInt();
            graph.edge[i].weight=sc.nextInt();
        }
        graph.Bellmanford(graph,0);
    }
    }

