public class BubbleSort {

    static void sort(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        printarray(arr);
    }

   static void printarray(int[] arr)
    {
        for (int j : arr) {
            System.out.print(" " + j);
        }
    }
    public static void main(String[] args) {
        int[] arr=new int[]{54,5,77,15,8};
        sort(arr);

    }
}
