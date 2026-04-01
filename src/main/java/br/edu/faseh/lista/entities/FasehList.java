package br.edu.faseh.lista.entities;

public class FasehList<T> {
    // Hold the reference to the first node of this List.
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int totalElements;

    private Node<T> getNewNode(T value) {
        return new Node<>(value);
    }

    public void insertAtBeginning(T value) {
        Node<T> newNode = getNewNode(value);
        newNode.setNext(firstNode);
        if (firstNode == null) {
            lastNode = newNode;
        }
        firstNode = newNode;
        totalElements++;
    }

    public boolean isTheListEmpty() {
        return firstNode == null;
    }

    public void insertAtTheEnd(T value) {
        Node<T> newNode = getNewNode(value);

        if (firstNode != null) {
            lastNode.setNext(newNode);
            lastNode = lastNode.getNext();
            totalElements++;
        } else {
            insertAtBeginning(value);
        }
    }

    public Node<T> removeAtBeginning() {
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    public Node<T> removeAtEnd() {
        Node<T> aux;
        Node<T> previous;

        if (isTheListEmpty()) {
            return null;
        } else {
            if(firstNode == lastNode) {
                aux = firstNode;
                lastNode = firstNode = null;

                return aux;
            } else {
                aux = firstNode.getNext();
                previous = firstNode;

                while( aux.getNext() != null) {
                    previous = aux;
                    aux = aux.getNext();
                }

                previous.setNext(null);
                lastNode = previous;
                totalElements--;
                return aux;
            }
        }
    }

    public Node<T> removeByValue(T value) {
        Node<T> aux;
        Node<T> previous;

        if (isTheListEmpty()) {
            return null;
        } else {
            if (value.equals(firstNode.getValue())) {
                return removeAtBeginning();
            } else {
                aux = firstNode.getNext();
                previous = firstNode;
                while( aux != null) {
                    if (value.equals(aux.getValue())) {
                        previous.setNext(aux.getNext());
                        totalElements--;
                        if(aux.getNext() == null)
                            lastNode = previous;
                        return aux;
                    }
                    previous = aux;
                    aux = aux.getNext();
                }
            }
        }
        return null;
    }

    public boolean searchByValue(T value) {
        Node<T> aux = firstNode;

        while (aux != null) {
            if (value.equals(aux.getValue())) {
                return true;
            }
            aux = aux.getNext();
        }

        return false;

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

        // Remove os dois últimos elementos da String, antes de finalizar
        // (elimina a vírgula e o espaço excedentes.
        builder.delete(builder.length() - 2, builder.length());

        builder.append("]");

        return builder.toString();
    }

    // Design the other list methods.
//    Insert at the end, in order, remove at the end,
//    remove elements by value, search an element.
}