package ru.sfedu.pKino.model;

import ru.sfedu.pKino.repository.interfaces.Entity;

public class Session extends Entity<Session> {

    private long id;
    private long film_id;
    private long hall_id;

    public Session(long id, long film_id, long hall_id) {
        this.id = id;
        this.film_id = film_id;
        this.hall_id = hall_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(long film_id) {
        this.film_id = film_id;
    }

    public long getHall_id() {
        return hall_id;
    }

    public void setHall_id(long hall_id) {
        this.hall_id = hall_id;
    }

}
