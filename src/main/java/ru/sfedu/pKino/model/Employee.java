package ru.sfedu.pKino.model;
import java.util.HashSet;

import java.util.Set;

public class Employee extends Man {

    public int id;
    private String position; //должность
    private Salary SumSalary;


    public Employee(int id, String position, Salary sumSalary, Set hall) {
        this.id = id;
        this.position = position;
        SumSalary = sumSalary;
        Hall = hall;
    }


    public Salary getSumSalary() {
        return SumSalary;
    }

    public void setSumSalary(Salary sumSalary) {
        SumSalary = sumSalary;
    }

    public void setHall(Set hall) {
        Hall = hall;
    }

    public Employee(String n, String s, String p){
        name = n;
        surname = s;
        position = p;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setPosition(String newProfession){
        position = newProfession;
    }
    public String getPosition(){
        return position;
    }




    public void setSalary(Salary c){
        SumSalary = c;
    }
    public Salary getSalary(){
        return SumSalary;
    }

    private Set Hall = new HashSet();
    public void setHall(Hall newHall){
        Hall.add(newHall);
    }
    public Set getHall(){
        return Hall;
    }
    public void deleteHall(Hall r){
        Hall.remove(r);
    }
}
