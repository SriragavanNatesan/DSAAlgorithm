package dsa.pattern.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void testbinarySearch() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(5, BinarySearch.binarySearch(arr, 5));
        assertEquals(0, BinarySearch.binarySearch(arr, 0));
        assertEquals(10, BinarySearch.binarySearch(arr, 10));
        assertEquals(-1, BinarySearch.binarySearch(arr, 11));

        assertEquals(9, BinarySearch.binarySearch(arr, 9));
    }

    @Test
    void testrecursiveBinarySearch() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(5, BinarySearch.recursiveBinarySearch(arr, 5, 0, 10));
        assertEquals(0, BinarySearch.recursiveBinarySearch(arr, 0, 0, 10));
        assertEquals(10, BinarySearch.recursiveBinarySearch(arr, 10, 0, 10));
        assertEquals(-1, BinarySearch.recursiveBinarySearch(arr, 11, 0, 10));
        assertEquals(9, BinarySearch.recursiveBinarySearch(arr, 9, 0, 10));
    }

    @Test
    void firstOccurence() {

        int[] arr = {2, 4, 10, 10, 10, 18, 20, 20, 27};

        assertEquals(-1, BinarySearch.firstOccurrence(arr, -1));
        assertEquals(2, BinarySearch.firstOccurrence(arr, 10));
        assertEquals(6, BinarySearch.firstOccurrence(arr, 20));
        assertEquals(5, BinarySearch.firstOccurrence(arr, 18));

        assertEquals(8, BinarySearch.firstOccurrence(arr, 27));
    }

    @Test
    void lastOccurence() {

        int[] arr = {2, 4, 10, 10, 10, 18, 20, 20, 27};

        assertEquals(-1, BinarySearch.lastOccurrence(arr, -1));
        assertEquals(4, BinarySearch.lastOccurrence(arr, 10));
        assertEquals(7, BinarySearch.lastOccurrence(arr, 20));
        assertEquals(5, BinarySearch.lastOccurrence(arr, 18));

        assertEquals(8, BinarySearch.lastOccurrence(arr, 27));
    }
}