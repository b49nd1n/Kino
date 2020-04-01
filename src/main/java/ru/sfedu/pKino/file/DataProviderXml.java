package ru.sfedu.pKino.file;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.pKino.Result;
import ru.sfedu.pKino.model.Employee;
import ru.sfedu.pKino.model.Film;
import ru.sfedu.pKino.model.Hall;
import ru.sfedu.pKino.model.Salary;

import java.util.List;

public class DataProviderXml implements IDataProvider {
    private static Logger log = LogManager.getLogger(DataProviderXml.class);
    @Override
    public void initDataSource() {

    }

    @Override
    public <T> Result addRecord(List<T> bean, Class clazz) {
        return null;
    }

    @Override
    public Result getRecordById(long id, Class clazz) {
        return null;
    }

    @Override
    public Result delRecordById(long id, Class clazz) {
        return null;
    }

    @Override
    public <T> Result updRecordById(List<T> bean, long id, Class clazz) {
        return null;
    }

    @Override
    public Result addemployee(List<Employee> bean) {
        return null;
    }

    @Override
    public Result getemployeeById(long id) {
        return null;
    }

    @Override
    public Result delemployeeById(long id) {
        return null;
    }

    @Override
    public Result updemployeeById(List<Employee> bean, long id) {
        return null;
    }

    @Override
    public Result addHall(List<Hall> bean) {
        return null;
    }

    @Override
    public Result getHallById(long id) {
        return null;
    }

    @Override
    public Result delHallById(long id) {
        return null;
    }

    @Override
    public Result updHallById(List<Hall> bean, long id) {
        return null;
    }

    @Override
    public Result addSalary(List<Salary> bean) {
        return null;
    }

    @Override
    public Result getSalaryById(long id) {
        return null;
    }

    @Override
    public Result delSalaryById(long id) {
        return null;
    }

    @Override
    public Result updSalaryById(List<Salary> bean, long id) {
        return null;
    }

    @Override
    public Result addFilm(List<Film> bean) {
        return null;
    }

    @Override
    public Result getFilmById(long id) {
        return null;
    }

    @Override
    public Result delFilmById(long id) {
        return null;
    }

    @Override
    public Result updFilmById(List<Film> bean, long id) {
        return null;
    }
}
