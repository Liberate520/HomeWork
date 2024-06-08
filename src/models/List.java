package models;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
    private Node<T> head, tail;

    public List() {
        head = null;
        tail = null;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data, null);
        if (head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(this);
    }

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private class ListIterator<T> implements Iterator<T> {
        Node<T> current;

        public ListIterator(List<T> list) {
            current = list.head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}
