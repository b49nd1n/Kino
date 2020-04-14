package ru.sfedu.pKino.model;

import ru.sfedu.pKino.repository.interfaces.Entity;

public class EmployeeType extends Entity<EmployeeType> {

    private long id;
    private String description;

    EmployeeType(){

    }

    public EmployeeType(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
