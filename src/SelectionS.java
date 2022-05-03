import java.util.Scanner;

public class SelectionS {
    static void prints(int[] arr)
    {
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(" "+arr[i]+" ");
        }
    }
    static void SSort(int[] arr)
    {
        int n=arr.length;
        for (int i = 0; i <n-1 ; i++) {
            int min_index=i;
            for (int j = i+1; j <n ; j++) {
                if(arr[min_index]>arr[j])
                {
                    min_index=j;
                }
            }
                int temp=arr[min_index];
                arr[min_index]=arr[i];
                arr[i]=temp;
            System.out.println("\nStep "+i+" \n");
                prints(arr);
        }

    }
    public static void main(String[] args) {
        int[] arr=new int[]{64,25,12,22,11};
        SSort(arr);
    }
}
