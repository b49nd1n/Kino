package ru.sfedu.pKino.repository.interfaces;

import ru.sfedu.pKino.Main;

import java.io.File;
import java.util.List;


public abstract class IDataProvider {

    static String FILE_EXTENSION;

    IDataProvider() {

    }

    static IDataProvider getInstance() {
        return null;
    }

    abstract public <T extends Entity> boolean saveRecord(T object, Repository repository);

    abstract public <T extends Entity> boolean updateRecord(T object, Repository repository);

    abstract public <T extends Entity> boolean deleteRecord(T object, Repository repository);

    abstract public <T extends Entity> List<T> findAll(Repository repository);

    public String getFilePath(Repository repository) {
        return Main.dataFolder + File.separator + getFilePath(repository) + FILE_EXTENSION;
    }
}
