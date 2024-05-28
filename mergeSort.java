import java.util.Random;
public class mergeSort{

    public static void main (String [] args){
        //I initiate a random to create an array with random numbers to be sorted

       Random rand = new Random ();
       int [] numbers = new int [20]; // initialise array of size 20;
       for (int i = 0; i < numbers.length; i++){
        numbers[i] = rand.nextInt(50000);// from 0 to 50000
       }
// print out our unsorted array first
          printArray(numbers);
          // mergesort our numbers
        
    }
    private static void mergeSort(int[] inputArray) {
        int length = inputArray.length;
        if (length < 2) {
            return;
        }
        int midIndex = length / 2;
    
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[length - midIndex];
    
        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = midIndex; i < length; i++) {
            rightHalf[i - midIndex] = inputArray[i]; // Corrected indexing
        }
    
        mergeSort(leftHalf);
        mergeSort(rightHalf);
    
        merge(inputArray, leftHalf, rightHalf);
    }
    
    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
    
        int i = 0;
        int j = 0;
        int k = 0;
    
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }
    
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize) { 
            inputArray[k] = rightHalf[j];
            k++;
            j++;
        }
    }
    

    private static void printArray(int [] inputArray){
        for (int i = 0; i < inputArray.length; i++){
            System.out.print(inputArray[i] + " ");
        }
    }
}