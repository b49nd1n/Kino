package ru.sfedu.pKino.model;

import ru.sfedu.pKino.constants.Constants;
import ru.sfedu.pKino.repository.interfaces.CsvConvertable;
import ru.sfedu.pKino.repository.interfaces.XMLConvertable;


public class Employee implements CsvConvertable, XMLConvertable {

    private long   id;
    private String name;
    private long   salary;
    private long   hall_id;
    private long   type_id;


    public Employee(int id, String name, int salary, int hall_id, int type_id) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.hall_id = hall_id;
        this.type_id = type_id;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getHall_id() {
        return hall_id;
    }

    public void setHall_id(int hall_id) {
        this.hall_id = hall_id;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }


    @Override
    public String convertToCsv() {
        return id + Constants.CSV_SEPARATOR
               + name + Constants.CSV_SEPARATOR
               + salary + Constants.CSV_SEPARATOR
               + hall_id + Constants.CSV_SEPARATOR
               + type_id + Constants.CSV_SEPARATOR;

    }

    @Override
    public String convertToXML() {
        return null;
    }
}
