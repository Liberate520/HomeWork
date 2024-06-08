package models;

import java.util.Iterator;

/**
 * Класс для представления связного списка.
 */
public class List<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;

    /**
     * Добавляет элемент в конец списка.
     *
     * @param data Данные элемента.
     */
    public void add(T data) {
        Node<T> node = new Node<>(data, null);
        if (head == null) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    /**
     * Возвращает голову списка.
     *
     * @return Голова списка.
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Возвращает хвост списка.
     *
     * @return Хвост списка.
     */
    public Node<T> getTail() {
        return tail;
    }

    /**
     * Возвращает итератор для итерации по списку.
     *
     * @return Итератор.
     */
    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

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

        public Node<T> getNext() {
            return next;
        }
    }
}