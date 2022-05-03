public class QuickSort {
    static void Swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    static int partition(int[] arr,int low, int high)
    {
        int p=arr[high];
        int i=low-1;
        for (int j = low; j <=high; j++) {
            if(arr[j]<p)
            {
                i++;
                Swap(arr,i,j);
            }
        }
        Swap(arr,i+1,high);
        return i+1;
    }

    static void quickSort(int[] arr,int low,int high)
    {
        if(low<high)
        {
            int pi=partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    static void prints(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{14,2,54,48,47,33,5,66,74};
        quickSort(arr,0,arr.length-1);
        prints(arr);
    }
}
