package ru.sfedu.pKino.repository.interfaces;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataProviderCsv extends IDataProvider {

    private volatile static DataProviderCsv dataProviderCsv;

    private static Logger log = LogManager.getLogger();

    private DataProviderCsv() {
        super();
    }

    public static DataProviderCsv getInstance() {

        if (dataProviderCsv == null) {
            dataProviderCsv = new DataProviderCsv();
            FILE_EXTENSION = ".csv";
        }

        return dataProviderCsv;
    }

    @Override
    public <T extends Entity> boolean saveRecord(T object, Repository repository) {

        if (object != null) {

            List<T> list = findAll(repository);
            list.add(object);

            return writeToFile(list
                            .stream()
                            .map(CsvSerializer::serialize).collect(Collectors.toList()),
                    getFilePath(repository));
        }

        return false;

    }


    private boolean writeToFile(List<String[]> data, String filePath) {

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            csvWriter.writeAll(data);
        } catch (IOException e) {
            log.error(e);
            return false;
        }
        return true;
    }


    @Override
    public <T extends Entity> boolean updateRecord(T object, Repository repository) {

        if (object != null) {

            List<T> list = findAll(repository);
            if (list != null) {

                writeToFile(list.stream().map(t -> {
                    if (t.compareById(object)) {
                        t.updateFromStrings(object.toStringsArray());
                    }
                    return CsvSerializer.serialize(t);
                }).collect(Collectors.toList()), getFilePath(repository));

            }

        }

        return false;

    }

    @Override
    public <T extends Entity> boolean deleteRecord(T object, Repository repository) {
        if (object != null) {

            List<T> list = findAll(repository);
            list.remove(object);

            return writeToFile(CsvSerializer.serializeAll(list), getFilePath(repository));
        }
        return false;
    }

    @Override
    public <T extends Entity> List<T> findAll(Repository repository) {

        List<String[]> list;
        List<T>        entities = new ArrayList<>();


        String filePath = getFilePath(repository);

        try {
            if (!Files.exists(Paths.get(filePath))) {
                Files.createFile(Paths.get(filePath));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {

            list = csvReader.readAll();

            list.forEach(strings -> entities.add(CsvSerializer.deserialize(strings)));

        } catch (IOException | CsvException e) {
            log.error(e);
            e.printStackTrace();
        }

        return entities;


    }

}
