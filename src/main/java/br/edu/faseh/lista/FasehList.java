package br.edu.faseh.lista;
public class FasehList<T> {
    // Hold the reference to the first node of this List.
    private Node<T> firstNode;
    private int totalElements;

    public void insertAtBeginning(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(firstNode);
        firstNode = newNode;
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
        if(this.totalElements == 0) {
            return "[ ]";
        }

        Node<T> currentNode = firstNode;
        StringBuilder builder = new StringBuilder("[");

        for (int i = 0; i < totalElements; i++) {
            builder.append(currentNode.getValue());
            builder.append(", ");

            currentNode = currentNode.getNext();

        }

        builder.append("]");

        return  builder.toString();
    }

    // Design the other list methods.
//    Insert at the end, in order, remove at the end,
//    remove elements by value, search an element. 
   
public void insertAtEnd(T value) {
    Node<T> newNode = new Node<>(value);

    if (firstNode == null) {
        firstNode = newNode;
    } else {
        Node<T> current = firstNode;

        while (current.getNext() != null) {
            current = current.getNext();
        }

        current.setNext(newNode);
    }

    totalElements++;
}

public boolean removeByKey(T value) {
    if (firstNode == null) {
        return false;
    }

    if (firstNode.getValue().equals(value)) {
        firstNode = firstNode.getNext();
        totalElements--;
        return true;
    }

    Node<T> current = firstNode;

    while (current.getNext() != null) {
        if (current.getNext().getValue().equals(value)) {
            current.setNext(current.getNext().getNext());
            totalElements--;
            return true;
        }
        current = current.getNext();
    }

    return false;
}
