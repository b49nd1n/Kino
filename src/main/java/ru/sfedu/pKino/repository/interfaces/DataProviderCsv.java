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

public class DataProviderCsv implements IDataProvider {

    private volatile static DataProviderCsv dataProviderCsv;

    private static Logger log = LogManager.getLogger();

    private CSVReader csvReader;
    private CSVWriter csvWriter;


    private DataProviderCsv() {
    }

    public static DataProviderCsv getInstance(String filename) throws IOException {

        if (dataProviderCsv == null) {
            dataProviderCsv = new DataProviderCsv();
            dataProviderCsv.csvWriter = new CSVWriter(new FileWriter(filename));
            dataProviderCsv.csvReader = new CSVReader(new FileReader(filename));
        }

        return dataProviderCsv;
    }


    @Override
    public void saveRecord(Convertable object) {
        if (object instanceof CsvConvertable) {
            csvWriter.writeNext(((CsvConvertable) object).convertToCsv());
        }
    }

    @Override
    public void deleteRecord(Convertable object) {
        if (object instanceof CsvConvertable) {

            try {
                csvWriter.writeAll(
                        csvReader.readAll().stream()
                                .filter(strings ->
                                        Arrays.compare(((CsvConvertable) object).convertToCsv(), strings) != 0)
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
