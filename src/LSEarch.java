import java.util.Scanner;

public class LSEarch {

    static Boolean search(int[] arr,int key)
    {
        for (int i = 0; i <arr.length; i++) {
            if(arr[i]==key)
            {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,2,5,4,7,9,14};
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter element to search");
        int key=sc.nextInt();
        Boolean ans=search(arr,key);
        if(ans)
            System.out.println(key+" Found");
        else
            System.out.println(key+" Not found");
    }
}
