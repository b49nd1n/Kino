package ru.sfedu.pKino.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void stringsTest() throws IllegalAccessException {

        Employee e = new Employee();
        Assert.assertArrayEquals(new String[]{"id", "name", "salary", "hall_id", "type_id"}, e.getFieldsNames());


        e.setId(0);
        e.setName("Vasya");
        e.setSalary(100);
        e.setType_id(1);
        e.setHall_id(2);

        Assert.assertArrayEquals(new String[]{"0", "Vasya", "100", "2", "1"}, e.toStringsArray());


        Assert.assertArrayEquals(new String[]{"2", "Vasya1", "1000", "10", "22"},
                e.updateFromStrings(new String[]{"2", "Vasya1", "1000", "10", "22"}).toStringsArray());


    }

}