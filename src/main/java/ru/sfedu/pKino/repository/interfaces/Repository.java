package ru.sfedu.pKino.repository.interfaces;

import ru.sfedu.pKino.Main;

import java.io.IOException;

public interface Repository<T> {

    default IDataProvider getDataProvider(String className) throws IOException {

        switch (Main.dataType) {

            case CSV: {

                return DataProviderCsv.getInstance(className);
            }
            case XML: {

                return DataProviderXml.getInstance(className);
            }

            case JDBC: {

//                return DataProviderJDBC...

            }
        }
        return null;

    }

    void save(T object);

    void delete(T object);

    T getById(Long id);

}
