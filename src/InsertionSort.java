public class InsertionSort {

    static void prints(int[] arr) {
        for (int i = 0; i <arr.length; i++)
        {
            System.out.print(" " + arr[i]);
        }
    }

    static void sort(int[] arr)
    {
        int n=arr.length;
        for (int i = 1; i <n ; i++) {
            int key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j]>key)
            {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
            System.out.println();
            prints(arr);
        }
       // prints(arr);
    }

    public static void main(String[] args)
    {
        int[] arr=new int[]{12,11,13,5,6};
    sort(arr);
    }
}
