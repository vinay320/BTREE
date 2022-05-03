import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    int V;
    LinkedList<Integer>[] arr;
    BFS(int v)
    {
        V=v;
        arr=new LinkedList[v];
        for (int i =0; i <v; i++) {
            arr[i]= new LinkedList();
        }
    }
        void addEgde(int source,int dest)
        {
            arr[source].add(dest);
        }

        void BFSearch(int source)
        {
            boolean visited[]=new boolean[V];
            LinkedList<Integer> queue=new LinkedList<>();
            visited[source]=true;
            queue.add(source);
            while (queue.size()!=0)
            {
                source=queue.poll();
                System.out.println(source+" ");
                Iterator<Integer> i=arr[source].listIterator();
                while (i.hasNext())
                {
                    int n=i.next();
                    if(!visited[n])
                    {   visited[n]=true;
                        queue.add(n);
                    }
              }
            }
        }

    public static void main(String[] args) {
        BFS obj=new BFS(4);
        obj.addEgde(0,1);
        obj.addEgde(3,0);
        obj.addEgde(2,3);
        obj.addEgde(1,2);
        obj.addEgde(3,2);

        System.out.println("Enter Source");
        obj.BFSearch(2);

    }
}
