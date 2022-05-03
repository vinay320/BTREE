import java.util.Scanner;

public class BinarySearch {

    static int search(int[] arr,int key)
    {
        int f=0;
        int l=arr.length;
        int mid=(f+l)/2;

        while (f<=l)
        {
            mid=(f+l)/2;
            if(arr[mid]==key)
            {
                return mid+1;
            }
            else {
                if (arr[mid] > key) {
                    l = mid - 1;
                }
                if (arr[mid] < key) {
                    f = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,3,4,5,6,7,8,9};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter element to search");
        int key=sc.nextInt();
       int res= search(arr,key);
       if(res>-1)
       {
           System.out.println("found at position "+res);
       }
       else
       {
           System.out.println("Not found");
       }
    }
}
