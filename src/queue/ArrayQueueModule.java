package queue;

import java.util.Arrays;

public class ArrayQueueModule {
    static private Object[] elements = new Object[2];
    static private int start = 0, end = 0;

    // Pre: i: start <= i <= end, queue[i] != null && element != null
    // Post: queue.end += 1, queue[end] == element
    static public void enqueue(Object element) {
        if ((end + 1) % elements.length == start) {
            elements = Arrays.copyOf(toArray(), elements.length * 2);
            start = 0;
            end = elements.length / 2 - 1;
        }
        elements[end] = element;
        end = (end + 1) % elements.length;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return queue[start]
    static public Object element() {
        if (!isEmpty()) {
            return elements[start];
        }
        return null;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return queue[start] && queue.start += 1
    static public Object dequeue() {
        if(!isEmpty()) {
            Object tmp = elements[start];
            elements[start] = null;
            start = (start + 1) % elements.length;
            return tmp;
        }
        return null;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return queue.end - queue.start
    static public int size() {
        if (end >= start) {
            return end - start;
        }
        return elements.length - start + end;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return queue.start == queue.end
    static public boolean isEmpty() {
        return end == start;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: queue.start = queue.end
    static public void clear() {
        elements = new Object[elements.length];
        start = 0;
        end = 0;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return new Object[queue.size] = [queue[start], queue[start+1], ... , queue[end]]
    static public Object[] toArray() {
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
