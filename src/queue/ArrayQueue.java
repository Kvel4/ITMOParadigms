package queue;

import java.util.Arrays;

public class ArrayQueue {
    private Object[] elements = new Object[2];
    private int start = 0, end = 0;

    // Pre: queue != null
    // Post: element added in queue, queue.lastElement == element
    public void enqueue(Object element) {
        if ((end + 1) % elements.length == start) {
            elements = Arrays.copyOf(toArray(), elements.length * 2);
            start = 0;
            end = elements.length / 2 - 1;
        }
        elements[end] = element;
        end = (end + 1) % elements.length;
    }

    // Pre: queue != null
    // Post: queue.isEmpty() ? null : queue.firstElement
    public Object element() {
        if (!isEmpty()) {
            return elements[start];
        }
        return null;
    }

    // Pre: queue != null
    // Post: queue.isEmpty() ? null : queue.firstElement was deleted && return queue.firstElement
    public Object dequeue() {
        if(!isEmpty()) {
            Object tmp = elements[start];
            elements[start] = null;
            start = (start + 1) % elements.length;
            return tmp;
        }
        return null;
    }

    // Pre: queue != null
    // Post: numbOfElements in queue
    public int size() {
        if (end >= start) {
            return end - start;
        }
        return elements.length - start + end;
    }

    // Pre: queue != null
    // Post: numberOfElements in queue == 0 ? true : false
    public boolean isEmpty() {
        return end == start;
    }

    // Pre: queue != null
    // Post: queue is empty
    public void clear() {
        elements = new Object[elements.length];
        start = 0;
        end = 0;
    }

    // Pre: queue != null
    // Post: Object[] == [queue.firstEl, queue.secondElement, ... , queue.lastElement]
    public Object[] toArray() {
        Object[] tmp = new Object[size()];
        if (start <= end) {
            System.arraycopy(elements, start, tmp, 0, end - start);
        } else {
            System.arraycopy(elements, start, tmp, 0, elements.length - start);
            System.arraycopy(elements, 0, tmp, elements.length - start, end);
        }
        return tmp;
    }
}
