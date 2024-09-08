/*
 * Name: Michael Ren
 * PID:  A16430317
 */

 import java.util.Arrays;
 import java.util.NoSuchElementException;
 
 /**
  * Title: dHeap Description: This program creates a Heap with d branching factor
  *
  * @author Michael Ren
  * @since 9/4/24
  *
  * @param <T> the type of elements held in this collection
  */
 
 public class dHeap<T extends Comparable<? super T>> implements HeapInterface<T> {
 
     public T[] heap;   // backing array
     private int d;      // branching factor
     private int nelems; // number of elements
     private boolean isMaxHeap; // indicates whether heap is max or min
 
     /**
      * Initializes a binary max heap with capacity = 10
      */
     @SuppressWarnings("unchecked")
     public dHeap() {
         heap=(T[]) new Comparable[10];
         d=2;
         nelems=0;
         isMaxHeap=true;
     }
 
     /**
      * Initializes a binary max heap with a given initial capacity.
      *
      * @param heapSize The initial capacity of the heap.
      */
     @SuppressWarnings("unchecked")
     public dHeap(int heapSize) {
         // TODO
         heap=(T[]) new Comparable[heapSize];
         d=2;
         nelems=0;
         isMaxHeap=true;
     }
 
     /**
      * Initializes a d-ary heap (with a given value for d), with a given initial
      * capacity.
      *
      * @param d         The number of child nodes each node in the heap should have.
      * @param heapSize  The initial capacity of the heap.
      * @param isMaxHeap indicates whether the heap should be max or min
      * @throws IllegalArgumentException if d is less than one.
      */
     @SuppressWarnings("unchecked")
     public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
         
        if (d<1)
        {throw new IllegalArgumentException();}

         heap=(T[]) new Comparable[heapSize];
         this.d=d;
         nelems=0;
         this.isMaxHeap=isMaxHeap;
     }
 
     @Override
     public int size() {
         return nelems;
     }
 
     @Override
     public T remove() throws NoSuchElementException {
         
        if (nelems==0)
        {throw new NoSuchElementException();} 
        T element=this.heap[0];
        this.heap[0]=this.heap[nelems-1];
        this.heap[nelems-1]=null;
        nelems--;
        percolateDown(0);
        return element;
        
         
     }
 
     @Override
     public void add(T item) throws NullPointerException {
        
        if (item==null)
        {throw new NullPointerException();}
        if (nelems==heap.length)
        {resize();
        }

         this.heap[nelems]=item;
         percolateUp(nelems);
         nelems++;

     }
 
     @SuppressWarnings("unchecked")
     @Override
     public void clear() {
         for (int i=0;i<nelems;i++)
         {this.heap[i]=null;}
         nelems=0;
     }
 
     @Override
     public T element() throws NoSuchElementException {
         
         if (nelems==0)
         {throw new NoSuchElementException();}
         return this.heap[0];
     }
 
     private int parent(int index) {
         return ((index-1)/this.d);
     }
 
     private void percolateUp(int index) {
         
         if (index==0)
         {return;}

        if (isMaxHeap)
        {
          if (this.heap[parent(index)].compareTo(this.heap[index])<0)
          {
            T temp=this.heap[index];
            this.heap[index]=this.heap[parent(index)];
            this.heap[parent(index)]=temp;
            percolateUp(parent(index));
          }
         else
         {return;}
        }

        else {
            if (this.heap[parent(index)].compareTo(this.heap[index])>0)
            {
            T temp=this.heap[index];
            this.heap[index]=this.heap[parent(index)];
            this.heap[parent(index)]=temp;
            percolateUp(parent(index));
            }
         else
         {return;}

        }

     }

     
     private void percolateDown(int index) {
         
         int childIndexStart = d * index + 1; 
         if (childIndexStart >= nelems) {
             return;
         }
     
         int lastChildIndex = Math.min(childIndexStart + d, nelems);
         int bestChildIndex = childIndexStart;
         T bestChildValue = heap[childIndexStart];

         for (int i = childIndexStart + 1; i < lastChildIndex; i++) {
            if (heap[i] != null) {
                if (isMaxHeap) {
                    if (heap[i].compareTo(bestChildValue) > 0) {
                        bestChildValue = heap[i];
                        bestChildIndex = i;
                    }
                } else {
                    if (heap[i].compareTo(bestChildValue) < 0) {
                        bestChildValue = heap[i];
                        bestChildIndex = i;
                    }
                }
            }
        }

        if ((isMaxHeap && heap[index].compareTo(bestChildValue) < 0) ||
        (!isMaxHeap && heap[index].compareTo(bestChildValue) > 0)) {
            T temp=this.heap[index];
            this.heap[index]=this.heap[bestChildIndex];
            this.heap[bestChildIndex]=temp;
        percolateDown(bestChildIndex);
    }

     }
 
     @SuppressWarnings("unchecked")
     private void resize() {
        int newCapacity;
        if (nelems == heap.length) {
        // Expand heap
        newCapacity = heap.length * 2;
    } 
        else {
        return;
    }
    T[] newHeap = (T[]) new Comparable[newCapacity];
    // Copy elements from array
    System.arraycopy(heap, 0, newHeap, 0, nelems);
    // Update heap reference 
    heap = newHeap;
     }
 
 }