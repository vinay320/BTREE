public class MST {
    public static final int V=5;
    int minkey(int key[],Boolean mstset[])
    {
        int min=Integer.MAX_VALUE;
        int min_index=-1;

        for (int i = 0; i < V; i++)
        {
                if(mstset[i]==false && key[i]<min)
                {
                    min=key[i];
                    min_index=i;
                }

        }
        return min_index;
    }

    void printmst(int parent[], int graph[][])
    {
        for (int i = 1; i <V ; i++)
        {
            System.out.println(parent[i]+" "+i+" "+graph[i][parent[i]]);
        }        
    }

    void primMst(int graph[][])
    {
        int parent[]=new int[V];
        int key[]=new int[V];

        Boolean mstset[]=new Boolean[V];


        for (int i = 0; i <V ; i++)
        {
                key[i]=Integer.MAX_VALUE;
                mstset[i]=false;
        }


        key[0]=0;
        parent[0]=-1;

        for (int i = 0; i < V-1; i++)
        {
            int u=minkey(key,mstset);
            mstset[u]=true;

            for (int j = 0; j <V ; j++)
            {
                if(graph[u][j]!=0 && mstset[j]==false  && graph[u][j]<key[j])
                {
                    parent[j]=u;
                    key[j]=graph[u][j];
                }
            }
        }
    printmst(parent,graph);
    }

    public static void main(String[] args) {
        MST obj=new MST();
        int graph[][]= new int[][]{ { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        obj.primMst(graph);
    }
}
