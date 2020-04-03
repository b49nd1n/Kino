package ru.sfedu.pKino;


import ru.sfedu.pKino.constants.Constants;
import ru.sfedu.pKino.model.Employee;
import ru.sfedu.pKino.repository.EmployeeRepository;

public class Main {

    public static Constants.DATA_TYPE dataType;
    public static String              dataFolder;

    public static void main(String[] args) {

        dataType = Constants.DATA_TYPE.CSV;
        dataFolder = "/tmp/KINO";


        for (int i = 0; i < 100; i++) {

            Employee employee = new Employee();
            employee.setId(i);
            employee.setSalary((int) (Math.random() * 1000));
            employee.setName("sdf");
            employee.setHall_id(100 - i);
            employee.setType_id(i * 2);

            new EmployeeRepository().save(employee);

        }

        System.out.println(new EmployeeRepository().getById(24L).toString());


    }


}
