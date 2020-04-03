package ru.sfedu.pKino.repository.interfaces;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sfedu.pKino.model.Employee;

class CsvSerializerTest {

    @Test
    void serializationTest() {

        Employee employee = new Employee();
        employee.setId(0);
        employee.setSalary(10);
        employee.setName("sdf");
        employee.setHall_id(1);
        employee.setType_id(2);

        Assert.assertArrayEquals(new String[]{"ru.sfedu.pKino.model.Employee", "0", "sdf", "10", "1", "2"},
                CsvSerializer.serialize(employee));

        Assert.assertEquals(employee, CsvSerializer.deserialize(CsvSerializer.serialize(employee)));

    }


}