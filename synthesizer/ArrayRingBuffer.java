package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //       Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;

    }


    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        // Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount >= capacity) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        fillCount = fillCount + 1;
        last = last + 1;
        if (last >= rb.length) {
            last = 0;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // Dequeue the first item. Don't forget to decrease fillCount and update
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T removed = rb[first];
        rb[first] = null;
        fillCount = fillCount - 1;
        first = first + 1;
        if (first >= rb.length) {
            first = 0;
        }
        return removed;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // Return the first item. None of your instance variables should change.
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T val = rb[first];
        return val;
    }

    // When you get to part 5, implement the needed code to support iteration.
    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<T> {
        private int position;
        KeyIterator() {
            position = 0;
        }
        public boolean hasNext() {
            return position < capacity;
        }
        public T next() {
            T val = rb[position];
            position += 1;
            return val;
        }
    }
}
