package ru.sfedu.pKino.repository.interfaces;

import java.io.IOException;
import java.util.List;


public interface IDataProvider {

    static IDataProvider getInstance(String filename) throws IOException{
        return null;
    };

    void saveRecord(Convertable object);

    void deleteRecord(Convertable object);

    List<Object> findAll();

}
