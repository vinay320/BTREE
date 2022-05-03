import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
    int V;
    LinkedList<Integer>[] arr;

    DFS(int v) {
        V = v;
        arr = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            arr[i] = new LinkedList();
        }
    }

    void addEgde(int source, int dest) {
        arr[source].add(dest);
    }

    void DFSs(boolean[] visted,int source)
    {
        visted[source]=true;
        System.out.println(source);
        Iterator<Integer> i=arr[source].listIterator();
        while (i.hasNext())
        {
            int n=i.next();
            if(!visted[n])
            {
                DFSs(visted,n);
            }
        }
    }

    void DFSearch(int source)
    {
        boolean visted[]=new boolean[V];

        DFSs(visted,source);
    }

    public static void main(String[] args) {
        DFS obj = new DFS(4);
        obj.addEgde(0, 1);
        obj.addEgde(3, 0);
        obj.addEgde(2, 3);
        obj.addEgde(1, 2);
        obj.addEgde(3, 2);

        System.out.println("Enter Source");
        obj.DFSearch(2);
    }
}
