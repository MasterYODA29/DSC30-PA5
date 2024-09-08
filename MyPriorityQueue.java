/*
 * Name: Michael Ren
 * PID:  A16340317
 */

/**
 * Priority Queue Implementation using dHeap.
 *
 * @author Michael Ren
 * @since A16430317
 *
 * @param <T> the type of elements held in this collection
 */

 public class MyPriorityQueue<T extends Comparable<? super T>> {

    private dHeap<T> pQueue;

    /**
     * Constructor that creates a new priority queue
     *
     * @param initialSize the given size
     */
    public MyPriorityQueue(int initialSize) {
        // TODO
        pQueue = new dHeap<>(4, initialSize, false);
    }

    /**
     * Inserts an element into the Priority Queue. The element received cannot be
     * null.
     *
     * @param element Element to be inserted.
     * @throws NullPointerException if the element received is null.
     * @return returns true
     */
    public boolean offer(T element) throws NullPointerException {
        // TODO
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        this.pQueue.add(element);
        return true;
    }

    /**
     * Retrieve and remove the head of this Priority Queue (smallest element), or null if the
     * queue is empty.
     *
     * @return The head of the queue (smallest element), or null if queue is empty.
     */
    public T poll() {
        // TODO
        if (pQueue.size() == 0) {
            return null;
        }
        return pQueue.remove();
    }

    /**
     * Clears the contents of the queue
     */
    public void clear() {
        // TODO
        pQueue.clear();
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if
     * this queue is empty.
     *
     * @return the head of the queue, null if the queue is empty
     */
    public T peek() {
        // TODO
        if (pQueue.size() == 0) {
            return null;
        }
        return pQueue.element();
    }

    /**
     * Return true is the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        // TODO
        return pQueue.size() == 0;
    }

}