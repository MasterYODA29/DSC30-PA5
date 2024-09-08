
import org.junit.jupiter.api.Assertions;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class dHeapTester {

    private dHeap<Integer> maxHeap;
    private dHeap<Integer> minHeap;

    @BeforeEach
    void setUp() {
        // Initialize heaps for each test
        maxHeap = new dHeap<>(3, 10, true); // Max-heap with d=3
        minHeap = new dHeap<>(3, 10, false); // Min-heap with d=3
    }

    // Tests for the size() method
    @Test
    void testSizeEmptyHeap() {
        assertEquals(0, maxHeap.size());
    }

    @Test
    void testSizeAfterAdd() {
        maxHeap.add(10);
        assertEquals(1, maxHeap.size());
    }

    @Test
    void testSizeAfterMultipleAdds() {
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        assertEquals(3, maxHeap.size());
    }

    // Tests for the add() method
    @Test
    void testAddNullThrowsException() {
        assertThrows(NullPointerException.class, () -> maxHeap.add(null));
    }

    @Test
    void testAddSingleElement() {
        maxHeap.add(15);
        assertEquals(15, maxHeap.element());
    }

    @Test
    void testAddAndResize() {
        for (int i = 0; i < 20; i++) {
            maxHeap.add(i);
        }
        assertEquals(20, maxHeap.size(), "Heap size should be 20 after adding 20 elements");
        maxHeap.remove();
        assertEquals(19, maxHeap.size());

    }

    // Tests for the remove() method
    @Test
    void testRemoveEmptyHeap() {
        assertThrows(NoSuchElementException.class, () -> maxHeap.remove(), "Removing from an empty heap should throw NoSuchElementException");
    }

    @Test
    void testRemoveSingleElement() {
        maxHeap.add(25);
        assertEquals(25, maxHeap.remove());
    }

    @Test
    void testRemoveMultipleElements() {
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        assertEquals(30, maxHeap.remove());
        assertEquals(20, maxHeap.remove());
    }

    // Tests for the clear() method
    @Test
    void testClear() {
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.clear();
        assertEquals(0, maxHeap.size());
        assertThrows(NoSuchElementException.class, () -> maxHeap.element(), "Accessing element of a cleared heap should throw NoSuchElementException");
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.remove();
        maxHeap.clear();
        assertEquals(0, maxHeap.size());
        maxHeap.remove();
        assertThrows(NoSuchElementException.class, () -> maxHeap.element()); 

    }

    // Tests for the element() method
    @Test
    void testElementEmptyHeap() {
        assertThrows(NoSuchElementException.class, () -> maxHeap.element(), "Accessing element of an empty heap should throw NoSuchElementException");
    }

    @Test
    void testElementAfterAdd() {
        maxHeap.add(50);
        assertEquals(50, maxHeap.element());
        maxHeap.add(35);
        assertEquals(50, maxHeap.element());
    }

    @Test
    void testElementAfterMultipleAdds() {
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        assertEquals(30, maxHeap.element());
    }

    @Test
    void testaddandRemove() {
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.remove();
        assertEquals(1, maxHeap.size());
        maxHeap.remove();
        assertEquals(0, maxHeap.size());

    }

    ////////////////////////////////////////////////////////////////////////////
    //for Minheap
    @Test
    void testminHeapSizeEmptyHeap() {
        assertEquals(0, minHeap.size());
    }

    @Test
    void testminHeapSizeAfterAdd() {
        maxHeap.add(10);
        assertEquals(1, minHeap.size());
    }

    @Test
    void testminHeapSizeAfterMultipleAdds() {
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(30);
        assertEquals(3, minHeap.size());
    }

    // Tests for the add() method
    @Test
    void testminHeapAddNullThrowsException() {
        assertThrows(NullPointerException.class, () -> minHeap.add(null));
    }

    @Test
    void testminHeapAddSingleElement() {
        maxHeap.add(15);
        assertEquals(15, minHeap.element());
    }

    @Test
    void testminHeapAddAndResize() {
        for (int i = 0; i < 20; i++) {
            minHeap.add(i);
        }
        assertEquals(20, minHeap.size(), "Heap size should be 20 after adding 20 elements");
        minHeap.remove();
        assertEquals(19, minHeap.size());

    }

    // Tests for the remove() method
    @Test
    void testminHeapRemoveEmptyHeap() {
        assertThrows(NoSuchElementException.class, () -> minHeap.remove(), "Removing from an empty heap should throw NoSuchElementException");
    }

    @Test
    void testminHeapRemoveSingleElement() {
        minHeap.add(25);
        assertEquals(25, minHeap.remove());
    }

    @Test
    void testminHeapRemoveMultipleElements() {
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(30);
        assertEquals(10, minHeap.remove());
        assertEquals(20, minHeap.remove());
    }

    // Tests for the clear() method
    @Test
    void testminHeapClear() {
        minHeap.add(10);
        minHeap.add(20);
        minHeap.clear();
        assertEquals(0, minHeap.size());
        assertThrows(NoSuchElementException.class, () -> minHeap.element(), "Accessing element of a cleared heap should throw NoSuchElementException");
        minHeap.add(10);
        minHeap.add(20);
        minHeap.remove();
        minHeap.clear();
        assertEquals(0, minHeap.size());
        minHeap.remove();
        assertThrows(NoSuchElementException.class, () -> minHeap.element()); 

    }

    // Tests for the element() method
    @Test
    void testminHeapElementEmptyHeap() {
        assertThrows(NoSuchElementException.class, () -> minHeap.element(), "Accessing element of an empty heap should throw NoSuchElementException");
    }

    @Test
    void testminHeapElementAfterAdd() {
        minHeap.add(50);
        assertEquals(50, minHeap.element());
        minHeap.add(35);
        assertEquals(35, minHeap.element());
    }

    @Test
    void testminHeapElementAfterMultipleAdds() {
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(30);
        assertEquals(10, minHeap.element());
    }

    @Test
    void testminHeapaddandRemove() {
        minHeap.add(10);
        minHeap.add(20);
        minHeap.remove();
        assertEquals(1, minHeap.size());
        minHeap.remove();
        assertEquals(0, minHeap.size());

    }

}

