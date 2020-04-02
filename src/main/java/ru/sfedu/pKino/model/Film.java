package ru.sfedu.pKino.model;

import ru.sfedu.pKino.repository.interfaces.Entity;

import java.sql.Timestamp;

public class Film extends Entity<Film> {
    private long       id;
    private String    title;
    private Timestamp startDate;
    private Timestamp endDate;


    public Film(long id, String title, Timestamp startDate, Timestamp endDate) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }


}
