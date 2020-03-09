package queue;

public interface Queue {
    // Pre: queue != null
    // Post: element added in queue, queue.lastElement == element
    void enqueue(Object element);

    // Pre: queue != null
    // Post: queue.isEmpty() ? null : queue.firstElement
    Object element();

    // Pre: queue != null
    // Post: queue.isEmpty() ? null : queue.firstElement was deleted && return queue.firstElement
    Object dequeue();

    // Pre: queue != null
    // Post: numbOfElements in queue
    int size();

    // Pre: queue != null
    // Post: numberOfElements in queue == 0 ? true : false
    boolean isEmpty();

    // Pre: queue != null
    // Post: queue is empty
    void clear();

    // Pre: queue != null
    // Post: Object[] == [queue.firstEl, queue.secondElement, ... , queue.lastElement]
    Object[] toArray();
}
