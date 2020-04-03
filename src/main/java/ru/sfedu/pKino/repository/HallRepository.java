package ru.sfedu.pKino.repository;

import ru.sfedu.pKino.model.Hall;
import ru.sfedu.pKino.repository.interfaces.Repository;

public class HallRepository extends Repository<Hall> {

    public HallRepository(String className) {
        super(className);
    }
}
