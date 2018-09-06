/*
 * Paul Bosonetto
 * CSCI 333
 * Homework 2: Heap
 * 2018.09.06
 * 
 * TODO: Implements a MaxHeap object that is constructed by passing an int[] array
 * to the constructor. It constructs the heap automatically at the creation of the object
 * A heapsort() method is implemented, but must be called manually
 * 
 * This is a 0-indexed MaxHeap
 * 
 *                  root at 0 
 * Left child        i*2 + 1  
 * Right child       i*2 + 2
 * Parent            floor(i/2)
 *
 */
package maxheap;

public class MaxHeap {
    
    protected int[] heap;
    protected int heapsize;

    public MaxHeap(int[] nums){
        
        this.heapsize = nums.length;
        this.heap = new int[heapsize];
        System.arraycopy(nums, 0, this.heap, 0, nums.length);
        
        buildMaxHeap();
    }
    
    protected void buildMaxHeap(){
        
        for (int i = heapsize/2; i >= 0; i--)
            maxHeapify(i);
    }
    
    protected void maxHeapify(int index){

        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int largest = index;
        
        //System.out.println("left: " + left + " right: " + right);
        
        if (left < heapsize && left != -1 && heap[left] > heap[index])
            largest = left;
        
        if (right < heapsize && right != -1 && heap[right] > heap[largest])
            largest = right;
        
        if (largest != index){
            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            
            maxHeapify(largest);
        }
    }
    
    public void heapsort(){
        
        int heapsizeBackup = heapsize;
        
        for (int i = heapsize-1; i >= 1; i--){
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;
            
            heapsize--;
            maxHeapify(0);
        }
        heapsize = heapsizeBackup;
    }

    protected int parentOf(int index){
        
        if (index == 0 || index > heapsize)
            return -1;
        
        return index/2;
    }
    
    protected int leftChildOf(int index){
        
        int childIndex = (index*2) +1;
        
        if (childIndex > heapsize)
            return -1;
        
        return childIndex;        
    }
    
    protected int rightChildOf(int index){
        
        int childIndex = (index*2) + 2;
        
        if (childIndex > heapsize)
            return -1;
        
        return childIndex;
    }

    public void printMaxHeap(){

        System.out.println("Heapsize: " + heapsize);
        System.out.print("Heap: ");

        for (int i = 0; i < heapsize-1; i++){
            System.out.print(heap[i] + ", ");
        }
        System.out.println(heap[heapsize-1]);
    }
}