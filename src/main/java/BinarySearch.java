/**
 * Created by Mostja on 15-Feb-15.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {1,5,18,27,95,102,115,190};
        int valueToFind = 27;
        int indexOfvalue = search(arr, valueToFind);
        System.out.print(indexOfvalue);


    }
    private static int search (int[] array, int value){
        return searchInternal(array, value, 0, array.length-1);
    }

    private static int searchInternal (int [] array, int value, int low, int high){
        int middle = low+(high - low)/2;
        if (low>high){
            return -1;
        }
        else if (array[middle] == value){
            return middle;
        }
        else if (value<array[middle]){
            return searchInternal(array, value, low, middle-1);
        }
        return searchInternal(array, value, middle+1,high);
        }
}
