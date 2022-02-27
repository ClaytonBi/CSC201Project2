public class Problem1 {
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArr(int[] array){
        if (array != null){
            for(int i = 0; i < array.length; ++i){
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    public static void my_quicksort(int[] array){
        if (array == null){
            System.out.println("Array is null, can't sort");
        }
        else if(array.length == 0){
            System.out.print("Empty array, can't sort");
        }
        else{
            quicksort_helper(array, 0, array.length - 1);
            System.out.println("Array sorted");
        }
    }

    private static void quicksort_helper(int[] array, int low, int high){
        if (low < high){//when low < high, the subarray has more than one elements, which means that it needs to be sorted
            int pivot = partition(array, low, high);
            quicksort_helper(array, low, pivot - 1);
            quicksort_helper(array, pivot + 1, high);
        }
    }
    private static int partition(int[] array, int low, int high){
        int pivot = array[low];//select first element of the subarray as pivot
        int i = low + 1;
        int j = high;
        while (true){
            //move j to the left until it reaches a value greater than or equal to the pivot
            while(array[j] < pivot){
                j--;
            }
            //move i to the left until it crosses with i or reaches a value less than the pivot
            while ((i <= j) && (array[i] >= pivot)){//(order of (i <= j) and (array[i] >= pivot) matters)
                i++;
            }
            if (i > j){
                break;
            }
            swap(array, j, i);
        }
        //after the while loop, all elements to the right of j are larger than or equal to the pivot,
        //and all elements to the left of j are less than the pivot
        swap(array, j, low);
        return j;
    }

    public static void main(String[] args){
        //examine algorithm
        int[] arr = {299,-20,2,4,9,4,3,2,1,6,7,3,4,67,7,65,54,155,-30};
        System.out.println("Before sorting:");
        printArr(arr);
        my_quicksort(arr);
        System.out.println("After sorting:");
        printArr(arr);
    }
}