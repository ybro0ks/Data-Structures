public class quicksort {
    public static void main (String [] args){
        int [] arr = {3, 3, 5, 7};
    }

    public static void quicksort (int [] arr, int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);
 // low is the starting segment of the array that needs to be sorted
 //high is the ending index of the array to be sorted these parameters help define the array segment
            quicksort(arr, low, pi -1); // subarray before the pivot from low to p-1
            quicksort(arr, pi + 1, high);// subarray after the pivot from pi+1 to high

            // everytime quicksort is called it called with low
            // as 0 representing first element of the array
            // and 1 as high as array length - 1
        }

        // whenever quicksort is called the size of the segment is reduced 
        // it narrows down the array until the entire thing is sorted
    
    }

    private static int partition(int [] arr, int low, int high){
        int pivot = arr[high];// takes the last element of the array as pivot
        int i = (low -1); // initialises our partition
        for(int j = low; j< high; j++){
            if (arr[j] < pivot){
                i++;
// when a loop increments if arrj is less than the pivot i is incremented
// and elelments at i and j are swapped
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            // swapped at index i + 1.?
        }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temo;

    return i+1;
}
