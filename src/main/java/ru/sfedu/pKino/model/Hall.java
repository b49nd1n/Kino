package ru.sfedu.pKino.model;

import ru.sfedu.pKino.repository.interfaces.Entity;

public class Hall extends Entity<Hall> {

    private long id;
    private String description;

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
