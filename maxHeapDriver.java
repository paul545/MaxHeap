/*
 * Paul Bosonetto
 * CSCI 333
 * Homework 2: Heap
 * 2018.09.06
 *
 * This is the driver for the MaxHeap class, it contains the main() method.
 * It runs a series of operations on five different int[] arrays in order to 
 * test the MaxHeap class
 *
 */
package maxheap;

public class maxHeapDriver {
  
    public static void main(String[] args) {
        
        int[] nums1 = {2,14,16,24,10};
        int[] nums2 = {1,5,4,7,8,34,16,9,2};
        int[] nums3 = {32, 25, 16, 98, 28, 87, 36, 5, 58, 21, 40, 71, 55, 21, 4, 52, 32, 51, 4, 44};
        int[] nums4 = {27, 5, 21, 51, 64, 88, 5, 77, 67, 87, 81, 17, 95, 88, 46, 32, 63, 76, 18, 83};
        int[] nums5 = {49, 52, 34, 47, 62, 71, 12, 6, 63, 87, 85, 94, 69, 55, 39, 46, 3, 70, 57, 65,
            67, 58, 84, 43, 21, 50, 93, 74, 96, 43, 20, 50, 7, 25, 77, 73, 12, 28, 9, 58, 30, 16, 23,
            48, 72, 22, 63, 73, 60, 99, 60, 80, 69, 58, 43, 16, 46, 37, 81, 5, 59, 61, 84, 14, 84, 19,
            98, 3, 45, 46, 25, 77, 50, 14, 29, 50, 54, 53, 1, 59};
        
        
        int[][] arrays = {nums1, nums2, nums3, nums4, nums5};
        
        MaxHeap mh;
        
        for (int[] arr : arrays){
            System.out.println("Original Array: " + java.util.Arrays.toString(arr));
            
            mh = new MaxHeap(arr);
            mh.printMaxHeap();
            mh.heapsort();
            mh.printMaxHeap();
            System.out.println();
        }
    }
}
