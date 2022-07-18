package dsa.pattern.binarysearch;

public class BinarySearch {
    public static int binarySearch(int arr[], int target){
        System.out.println("=====BinarySearch====");
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start) >> 1;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]  > target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
