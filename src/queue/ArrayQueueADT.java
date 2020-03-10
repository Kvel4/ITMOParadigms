package queue;

import java.util.Arrays;

public class ArrayQueueADT {
    private Object[] elements = new Object[2];
    private int start = 0, end = 0;

    // Pre: i: start <= i <= end, queue[i] != null && element != null
    // Post: queue.end += 1, queue[end] == element
    static public void enqueue(ArrayQueueADT queue, Object element) {
        if ((queue.end + 1) % queue.elements.length == queue.start) {
            queue.elements = Arrays.copyOf(toArray(queue), queue.elements.length * 2);
            queue.start = 0;
            queue.end = queue.elements.length / 2 - 1;
        }
        queue.elements[queue.end] = element;
        queue.end = (queue.end + 1) % queue.elements.length;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return queue[start]
    static public Object element(ArrayQueueADT queue) {
        if (!isEmpty(queue)) {
            return queue.elements[queue.start];
        }
        return null;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return queue[start] && queue.start += 1
    static public Object dequeue(ArrayQueueADT queue) {
        if(!isEmpty(queue)) {
            Object tmp = queue.elements[queue.start];
            queue.elements[queue.start] = null;
            queue.start = (queue.start + 1) % queue.elements.length;
            return tmp;
        }
        return null;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return queue.end - queue.start
    static public int size(ArrayQueueADT queue) {
        if (queue.end >= queue.start) {
            return queue.end - queue.start;
        }
        return queue.elements.length - queue.start + queue.end;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return queue.start == queue.end
    static public boolean isEmpty(ArrayQueueADT queue) {
        return queue.end == queue.start;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: queue.start = queue.end
    static public void clear(ArrayQueueADT queue) {
        queue.elements = new Object[queue.elements.length];
        queue.start = 0;
        queue.end = 0;
    }

    // Pre: start <= i <= end, queue[i] != null
    // Post: return new Object[queue.size] = [queue[start], queue[start+1], ... , queue[end]]
    static public Object[] toArray(ArrayQueueADT queue) {
        Object[] tmp = new Object[size(queue)];
        if (queue.start <= queue.end) {
            System.arraycopy(queue.elements, queue.start, tmp, 0, queue.end - queue.start);
        } else {
            System.arraycopy(queue.elements, queue.start, tmp, 0, queue.elements.length - queue.start);
            System.arraycopy(queue.elements, 0, tmp, queue.elements.length - queue.start, queue.end);
        }
        return tmp;
    }
}
