package ru.sfedu.pKino.repository.interfaces;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DataProviderXml implements IDataProvider {


    private volatile static DataProviderXml dataProviderXml;

    private static Logger log = LogManager.getLogger();

    private CSVReader csvReader;
    private CSVWriter csvWriter;


    private DataProviderXml() {
    }

    public static DataProviderXml getInstance(String filename) throws IOException {

        if (dataProviderXml == null) {
            dataProviderXml = new DataProviderXml();
            dataProviderXml.csvWriter = new CSVWriter(new FileWriter(filename));
            dataProviderXml.csvReader = new CSVReader(new FileReader(filename));
        }

        return dataProviderXml;
    }


    @Override
    public void saveRecord(Entity object) {
        if (object != null) {
            csvWriter.writeNext(object.toStringsArray());
        }
    }

    @Override
    public void deleteRecord(Entity object) {
        if (object != null) {

            try {
                csvWriter.writeAll(
                        csvReader.readAll().stream()
                                .filter(strings ->
                                        Arrays.compare(object.toStringsArray(), strings) != 0)
                                .collect(Collectors.toList()));
            } catch (IOException | CsvException e) {
                log.error(e);
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Object> findAll() {
        return null;
    }
}
