package ru.sfedu.pKino.repository.interfaces;

import ru.sfedu.pKino.Main;

public abstract class Repository<T extends Entity> {

    private String        filePath;
    private IDataProvider dataProvider;

    public Repository(String className) {

        this.filePath = className;

        switch (Main.dataType) {

            case CSV: {

                setDataProvider(DataProviderCsv.getInstance());
            }
            case XML: {

                setDataProvider(DataProviderXml.getInstance());
            }

            case JDBC: {

                setDataProvider(DataProviderJDBC.getInstance());

            }
        }
    }

    public IDataProvider getDataProvider() {
        return dataProvider;
    }

    public void setDataProvider(IDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public String getFilePath() {
        return filePath;
    }

    public void save(T object) {
        dataProvider.saveRecord(object, this);
    }

    public void delete(T object) {
        dataProvider.deleteRecord(object, this);
    }

    public T getById(Long id) {
        return (T) dataProvider.findAll(this).stream()
                .filter(entity -> entity.compareById(id))
                .findFirst().orElse(null);
    }

}
