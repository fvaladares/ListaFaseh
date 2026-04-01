package br.edu.faseh.lista;


public class Main {
    public static void main(String[] args) {
        FasehList<Integer> myList = new FasehList<>();

        for (int i = 0; i < 10; i++) {
            myList.insertAtBeginning(i + 1);
            System.out.println(myList);
        }

        System.out.println(myList);

        Node<Integer> val = myList.removeAtBeginning();

        System.out.println(myList);

        System.out.println();

        System.out.println("Inserting data at the end");

        myList.insertAtTheEnd(2026);

        System.out.println(myList);

        System.out.println(myList.searchByValue(500));
        System.out.println(myList.searchByValue(2026));
        System.out.println(myList.searchByValue(9));
        System.out.println(myList.searchByValue(1));
        System.out.println(myList.searchByValue(2));

        myList.removeByValue(9);
        System.out.println(myList);

        myList.removeByValue(4);
        System.out.println(myList);

        myList.removeByValue(2026);
        System.out.println(myList);

        myList.removeAtEnd();
        System.out.println(myList);
    }
}