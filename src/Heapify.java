
public class Heapify {
    public void sort(int[] arr,int n)
    {
        for (int i=n/2-1;i>=0;i--)
        {
            heapsort(arr,n,i);
        }
        for (int i=n-1;i>=0;i--)
        {
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapsort(arr,i,0);
        }
    }

    static void heapsort(int[] arr,int n,int i)
    {
        int lasrgest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && arr[left]>arr[lasrgest])
        {
            lasrgest=left;
        }
        if(right<n && arr[right]>arr[lasrgest])
        {
            lasrgest=right;
        }
        if(lasrgest!=i)
        {
            int swap=arr[i];
            arr[i]=arr[lasrgest];
            arr[lasrgest]=swap;
            heapsort(arr,n,lasrgest);
        }
    }

    void printArray(int[] arr)
    {
        for (int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr={13,11,12,5,6,7};
        int n=arr.length;
        Heapify obj=new Heapify();
        obj.sort(arr,n);
        System.out.println("Sorted");
        obj.printArray(arr);
    }
}
