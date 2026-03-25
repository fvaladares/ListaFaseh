package br.edu.faseh.lista;

public class FasehList<T> {
    // Hold the reference to the first node of this List.
    private Node<T> firstNode;
    private int totalElements;

    private Node<T> getNewNode(T value) {
        return new Node<>(value);
    }

    public void insertAtBeginning(T value) {
        Node<T> newNode = getNewNode(value);
        newNode.setNext(firstNode);
        firstNode = newNode;
        totalElements++;
    }

    public void insertAtTheEnd(T value) {
        Node<T> newNode = getNewNode(value);
        Node<T> aux = firstNode;

        if (firstNode != null) {
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            aux.setNext(newNode);
        } else {
            insertAtBeginning(value);
        }

        totalElements++;


    }

    public Node<T> removeAtBeginning() {
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    @Override
    public String toString() {
        if (this.totalElements == 0) {
            return "[ ]";
        }

        Node<T> currentNode = firstNode;
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalElements; i++) {
            builder.append(currentNode.getValue());
            builder.append(", ");

            currentNode = currentNode.getNext();

        }

        builder.delete(builder.length()-2, builder.length());

        builder.append("]");

        return builder.toString();
    }

    // Design the other list methods.
//    Insert at the end, in order, remove at the end,
//    remove elements by value, search an element.
}