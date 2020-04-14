package ru.sfedu.pKino.repository;

import ru.sfedu.pKino.model.Employee;
import ru.sfedu.pKino.repository.interfaces.Repository;

import java.io.IOException;
import java.util.List;

public class EmployeeRepository extends Repository<Employee> {


    public EmployeeRepository(){
        super();
    }

    void saveFirst(List<Employee>list){
        save(list.get(0));

    }


    public static void main(String[] args) {
    }

}
