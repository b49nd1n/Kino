package ru.sfedu.pKino.repository;

import ru.sfedu.pKino.repository.interfaces.IDataProvider;
import ru.sfedu.pKino.repository.interfaces.Repository;
import ru.sfedu.pKino.model.Employee;

import java.io.IOException;

public class EmployeeRepository implements Repository<Employee> {


    private IDataProvider dataProvider;

    EmployeeRepository(){

        try {
            dataProvider = getDataProvider(Employee.class.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save(Employee object) {
        dataProvider.saveRecord(object);
    }

    @Override
    public void delete(Employee object) {
        dataProvider.deleteRecord(object);
    }

    @Override
    public Employee getById(Long id) {
        return null;
    }


}
