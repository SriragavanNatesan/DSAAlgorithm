package dsa.pattern.binarysearch;

public class BinarySearch {
    public static int binarySearch(int arr[], int target){
        System.out.println("=====binarySearch====");
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + ((end - start) >> 1);
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]  > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int recursiveBinarySearch(int arr[], int target,int start,int end){

//        System.out.println("=====recursiveBinarySearch====");
        if(start <= end){
            int mid = start + ((end - start) / 2 );
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]  > target){
                return recursiveBinarySearch(arr, target, start, mid -1);
            }else {
                return recursiveBinarySearch(arr, target, mid + 1, end);
            }
        }

        return -1;
    }

    public static int firstOccurrence(int arr[], int target){
        System.out.println("=====firstOccurence====");
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end){
            int mid = start + ((end - start) >> 1);
            if(arr[mid] == target){
                result = mid;
                end = mid -1;
            }else if(arr[mid]  > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static int lastOccurrence(int arr[], int target){
        System.out.println("=====lastOccurence====");
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end){
            int mid = start + ((end - start) >> 1);
            if(arr[mid] == target){
                result = mid;
                start = mid  + 1;
            }else if(arr[mid]  > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return result;
    }
}
