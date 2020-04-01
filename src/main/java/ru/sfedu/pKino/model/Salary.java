package ru.sfedu.pKino.model;

public class Salary {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;

    public int Sum; //зарплата
    public Salary(int n){
        Sum = n;
    }
    public void setSum(int newSum){
        Sum = newSum;
    }
    public int getSum(){
        return Sum;
    }


}
