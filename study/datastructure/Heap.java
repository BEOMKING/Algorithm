package study.datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class Heap<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private final Comparator<? super E> comparator;
    E[] arr;
    int size;

    public Heap(Comparator<? super E> comparator) {
        this.comparator = comparator;
        this.arr = (E[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(E e) {
        if (size + 1== arr.length) {
            resize(size * 2);
        }

        siftUp(size + 1, e);
        size++;
    }

    private void siftUp(int index, final E target) {
        while (index > 1) {
            int parent = index / 2;

            if (comparator.compare(arr[parent], target) >= 0) {
                break;
            }

            arr[index] = arr[parent];
            index = parent;
        }

        arr[index] = target;
    }

    public E pop() {
        if (arr[1] == null) {
            throw new NoSuchElementException();
        }

        E e = arr[1];
        E target = arr[size];
        arr[size] = null;
        arr[1] = null;

        siftDown(1, target);

        return e;
    }

    private void siftDown(int parent, E target) {
        size--;

        while (parent * 2 < size) {
            E left = arr[parent * 2];
            E right;
            int index = parent * 2;
            E value = left;

            if (parent * 2 + 1 < size && comparator.compare(left, (right = arr[parent * 2 + 1])) < 0) {
                index = parent * 2 + 1;
                value = right;
            }

            if (comparator.compare(target, value) >= 0) {
                break;
            }

            parent = index;
        }

        arr[parent] = target;
    }

    private void resize(int newCapacity) {
        this.arr = (E[]) Arrays.copyOf(new Object[newCapacity], newCapacity);
    }

    public static void main(String[] args) {
        Heap<Integer> heap = new Heap<>((o1, o2) -> o1 - o2);
        heap.add(5);
        heap.add(3);
        heap.add(7);

        System.out.println(heap.pop());
        System.out.println(heap.pop());
        System.out.println(heap.pop());
    }
}
