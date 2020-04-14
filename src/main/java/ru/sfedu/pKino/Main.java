package ru.sfedu.pKino;


import ru.sfedu.pKino.constants.Constants;
import ru.sfedu.pKino.model.EmployeeType;
import ru.sfedu.pKino.repository.EmployeeTypeRepository;

public class Main {

    public static Constants.DATA_TYPE dataType;
    public static String              dataFolder;

    public static void main(String[] args) {

        dataType = Constants.DATA_TYPE.XML;
        dataFolder = "/tmp/KINO";

        if (args.length < 2) {
            printHelp();
        }

//
//        for (int i = 0; i < 100; i++) {
//
//            Employee employee = new Employee();
//            employee.setId(i);
//            employee.setSalary((int) (Math.random() * 1000));
//            employee.setName("sdf");
//            employee.setHall_id(100 - i);
//            employee.setType_id(i * 2);
//
//            new EmployeeRepository().save(employee);
//
//        }

//        System.out.println(new EmployeeRepository().getById(24L).toString());


        EmployeeType employeeType = new EmployeeType(0, "123");
        new EmployeeTypeRepository().save(employeeType);


    }

    private static void printHelp() {
        System.out.println();

    }

    private static void printUnrecognized(String opt) {
        System.out.println("kinodb: unrecognized option '" + opt + "'\n"
                           + "Try 'kinodb --help' for more information.\n");
    }


}
