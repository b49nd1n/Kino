package ru.sfedu.pKino.repository.interfaces;

import java.lang.reflect.Field;
import java.sql.Timestamp;

public abstract class Entity<T> {

    public String[] getFiledsNames() {

        Field[]  fields = this.getClass().getDeclaredFields();
        String[] names  = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            names[i] = fields[i].getName();
        }
        return names;

    }

    public String[] toStringsArray() {
        Field[]  fields = getClass().getDeclaredFields();
        String[] data   = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            try {

                fields[i].setAccessible(true);
                data[i] = String.valueOf(fields[i].get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public T updateFromStrings(String[] data) throws IllegalAccessException {

        Field[] fields = getClass().getDeclaredFields();


        for (int i = 0; i < data.length; i++) {

            fields[i].setAccessible(true);

            if (fields[i].getType() == Integer.class || fields[i].getType() == int.class) {

                fields[i].set(this, Integer.parseInt(data[i]));

            } else if (fields[i].getType() == Long.class || fields[i].getType() == long.class) {

                fields[i].set(this, Long.parseLong(data[i]));

            } else if (fields[i].getType() == String.class) {

                fields[i].set(this, data[i]);

            } else if (fields[i].getType() == Timestamp.class) {

                fields[i].set(this, Timestamp.valueOf(data[i]));

            }

        }

        return (T) this;

    }

}
