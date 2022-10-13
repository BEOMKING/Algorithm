package study.datastructure;

/**
 * https://st-lab.tistory.com/167 참고
 */
public class SinglyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private Node<T> search(final int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> node = head;

        for (int i = 0; i < index; i++) {
            node = node.next();
        }

        return node;
    }

    private void addFirst(final T data) {
        final Node<T> node = new Node<>(data);

        node.setNext(head);
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    private void addLast(final T data) {
        if (size == 0) {
            addFirst(data);
            return;
        }

        final Node<T> node = new Node<>(data);

        tail.setNext(node);
        tail = node;
        size++;
    }

    private void add(final T data, final int index) {
        if (index < 0 || index > size) {
            throw new IllegalStateException();
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> beforeNode = search(index - 1);
        Node<T> newNode = new Node<>(data);
        Node<T> afterNode = beforeNode.next();
        beforeNode.setNext(newNode);
        newNode.setNext(afterNode);
        size++;
    }

    private Node<T> remove() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        Node<T> removeNode = head;
        Node<T> nextNode = head.next();
        head = nextNode;
        size--;

        if (size == 0) {
            tail = null;
        }

        return removeNode;
    }

    private Node<T> remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalStateException();
        }

        if (index == 0) {
            return remove();
        }

        Node<T> beforeNode = search(index - 1);
        Node<T> removeNode = beforeNode.next();
        Node<T> afterNode = removeNode.next;

        beforeNode.setNext(afterNode);
        size--;

        if (beforeNode.next == null) {
            tail = beforeNode;
        }

        return removeNode;
    }

    private boolean remove(Object value) {
        Node<T> node = head;
        Node<T> beforeNode = null;

        while (node != null) {
            if (node.data().equals(value)) {
                break;
            }

            beforeNode = node;
            node = node.next();
        }

        if (node == null) {
            return false;
        }

        if (beforeNode == null) {
            remove();
        } else {
            Node<T> afterNode = node.next();
            beforeNode.setNext(afterNode);
            size--;

            if (beforeNode.next == null) {
                tail = beforeNode;
            }
        }

        return true;
    }

    static class Node<T> {
        private Node<T> next;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node<T> next() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T data() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        final SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    }
}
