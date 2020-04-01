package ru.sfedu.pKino.model;

public class Hall {
    public int id;
    private int numViewer;
    private int number;
    public Hall(int n){
        number = n;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int newNumber){
        number = newNumber;
    }
    public int getNumber(){
        return number;
    }
}
