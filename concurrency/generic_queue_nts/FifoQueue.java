interface FifoQueue <T> {
    void enqueue(T item);// never fails
    T dequeue();         // returns null if empty,
                            // else returns items in order queued
    boolean isEmpty();      // true if nothing in queue
    int getQueueLength();   // returns number currently in queue
}
