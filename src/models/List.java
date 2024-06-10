package models;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
    private Node head, tail;

    public List() {
        head = null;
        tail = null;
    }

    public void add(T data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }

    public Node getHead() {
        return head;
    }

    private class Node {
        public Node next;
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
