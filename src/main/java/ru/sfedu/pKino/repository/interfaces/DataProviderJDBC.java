package ru.sfedu.pKino.repository.interfaces;

import java.util.List;

public class DataProviderJDBC extends IDataProvider {


    @Override
    public <T extends Entity> boolean saveRecord(T object, Repository repository) {
        return false;
    }

    @Override
    public <T extends Entity> boolean updateRecord(T object, Repository repository) {
        return false;
    }

    @Override
    public <T extends Entity> boolean deleteRecord(T object, Repository repository) {
        return false;
    }

    @Override
    public <T extends Entity> List<T> findAll(Repository repository) {
        return null;
    }
}
