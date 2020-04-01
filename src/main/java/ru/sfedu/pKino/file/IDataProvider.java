package ru.sfedu.pKino.file;
import java.util.List;

import ru.sfedu.pKino.Result;
import ru.sfedu.pKino.model.*;


public interface IDataProvider {

    public void initDataSource();
//    Generalized method

    public <T> Result addRecord(List<T> bean, Class clazz);
    public Result getRecordById(long id, Class clazz);
    public Result delRecordById(long id, Class clazz);
    public <T> Result updRecordById(List<T> bean, long id, Class clazz);

    //  Employee
    public Result addemployee(List<Employee> bean);
    public Result getemployeeById(long id);
    public Result delemployeeById(long id);
    public Result updemployeeById(List<Employee> bean, long id);

    //  Hall
    public Result addHall(List<Hall> bean);
    public Result getHallById(long id);
    public Result delHallById(long id);
    public Result updHallById(List<Hall> bean, long id);



    //    Salary
    public Result addSalary(List<Salary> bean);
    public Result getSalaryById(long id);
    public Result delSalaryById(long id);
    public Result updSalaryById(List<Salary> bean, long id);

    //    Film
    public Result addFilm(List<Film> bean);
    public Result getFilmById(long id);
    public Result delFilmById(long id);
    public Result updFilmById(List<Film> bean, long id);


}
