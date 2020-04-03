package ru.sfedu.pKino.repository.interfaces;

import java.util.List;


public abstract class IDataProvider {

    private String filePath;


    IDataProvider() {

    }

    static IDataProvider getInstance() {
        return null;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    abstract public <T extends Entity> boolean saveRecord(T object, Repository repository);

    abstract public <T extends Entity> boolean updateRecord(T object, Repository repository);

    abstract public <T extends Entity> boolean deleteRecord(T object, Repository repository);

    abstract public <T extends Entity> List<T> findAll(Repository repository);
}
