package br.edu.faseh.lista.entities;

public class FasehStack<T> {
    private Node<T> top;
    private int size;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T element) {
        Node<T> newElement = getNewElement(element);

        if (!isEmpty()) {
            newElement.setPrevious(top);
        }
        top = newElement;
        size++;
    }

    public Node<T> pop(){
        Node<T> aux;
        if(!isEmpty()) {
            aux = top;
            top = top.getPrevious();
            size--;
            return aux;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "[ ]";
        }

        Node<T> currentNode = top;
        StringBuilder builder = new StringBuilder("TOP -> [");

        while (currentNode != null) {
            builder.append(currentNode.getValue());
            builder.append(", ");
            currentNode = currentNode.getPrevious();
        }

        // Remove os dois últimos elementos da String, antes de finalizar
        // (elimina a vírgula e o espaço excedentes).
        builder.delete(builder.length() - 2, builder.length());
        builder.append("]");
        return builder.toString();
    }

    private Node<T> getNewElement(T element) {
        return new Node<>(element);
    }

    public int getSize() {
        return size;
    }
}
