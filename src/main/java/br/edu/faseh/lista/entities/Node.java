package br.edu.faseh.lista.entities;

// You can extend comparable interface,
// this enables you to check if two elements are or not equals.

public class Node<T> {
    private final T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T valor) {
        this.value = valor;
        this.next = null;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }
}