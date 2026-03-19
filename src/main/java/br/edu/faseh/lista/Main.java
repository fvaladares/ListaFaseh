package br.edu.faseh.lista;


public class Main {
    public static void main(String[] args) {
        FasehList<Integer> myList = new FasehList<>();

        for (int i = 0; i < 10; i++) {
            myList.insertAtBeginning(i + 1);
            System.out.println(myList);
        }

        System.out.println(myList);

        myList.removeAtBeginning();

        System.out.println(myList);

        System.out.println();
    }
}