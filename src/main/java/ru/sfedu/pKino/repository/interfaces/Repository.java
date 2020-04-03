package ru.sfedu.pKino.repository.interfaces;

import ru.sfedu.pKino.Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Repository<T extends Entity> {

    private String        filePath;
    private IDataProvider dataProvider;
    private String        typePattern = ".*?<.*\\.(?<type>[^.]+)>";

    public Repository() {

        Matcher m = Pattern.compile(typePattern).matcher(getClass().getGenericSuperclass().getTypeName());
        if (m.find()) {
            filePath = m.group("type");
        }

        switch (Main.dataType) {

            case CSV: {

                setDataProvider(DataProviderCsv.getInstance());
                break;
            }
            case XML: {

                setDataProvider(DataProviderXml.getInstance());
                break;
            }

            case JDBC: {

                setDataProvider(DataProviderJDBC.getInstance());
                break;
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
