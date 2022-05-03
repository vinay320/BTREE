import javax.security.sasl.SaslClient;
import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>
{
    int src=0;
    int dest=0;
    int weight=0;
    public int compareTo(Edge compareEgde)
    {
        return this.weight-compareEgde.weight;
    }
}
public class Krushal {


    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();

        Edge inp[] =new Edge[e];
        for(int i=0;i<e;i++)
        {
            inp[i]=new Edge();
            inp[i].src=sc.nextInt();
            inp[i].dest=sc.nextInt();
            inp[i].weight=sc.nextInt();
        }
        kruskals(inp,v,e);
    }
    public static void kruskals(Edge[] inp,int v,int e)
    {
        Arrays.sort(inp);
        Edge op[]=new Edge[v-1];
        int k=0;
        int[] parent=new int[v];
        for (int i = 0; i <v ; i++)
        {
            parent[i]=i;
        }
        for (int i = 0; i <e ; i++) {
            if (k == v - 1)
                break;

            Edge currEdge = inp[i];
            int src_parent = find(currEdge.src, parent);
            int dst_parent = find(currEdge.dest, parent);

            if (src_parent != dst_parent)
            {   op[k] = currEdge;
                k++;
                parent[src_parent] = dst_parent;
            }
        }
        for (int i = 0; i <op.length ; i++)
        {
            System.out.println(op[i].src+"---->"+op[i].dest+"----->"+op[i].weight);
        }
    }
    private static int find(int v,int[] parent)
    {
        if(parent[v]==v)
            return v;
        return find(parent[v],parent);
    }

}
