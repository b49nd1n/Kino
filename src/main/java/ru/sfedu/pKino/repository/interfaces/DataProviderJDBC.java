package ru.sfedu.pKino.repository.interfaces;

import java.util.List;

public class DataProviderJDBC extends IDataProvider {

    @Override
    public <T extends Entity> void saveRecord(T object, Repository repository) {

    }

    @Override
    public <T extends Entity> void updateRecord(T object, Repository repository) {

    }

    @Override
    public <T extends Entity> void deleteRecord(T object, Repository repository) {

    }

    @Override
    public <T extends Entity> List<T> findAll(Repository repository) {
        return null;
    }
}
