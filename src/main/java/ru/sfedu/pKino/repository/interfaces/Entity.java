package ru.sfedu.pKino.repository.interfaces;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

public class Entity<T> {

    public String[] getFieldsNames() {

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

    public T updateFromStrings(String[] data) {

        Field[] fields = getClass().getDeclaredFields();


        for (int i = 0; i < data.length; i++) {

            try {

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

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }

        return (T) this;

    }

    @Override
    public int hashCode() {
        return Arrays.stream(getClass().getDeclaredFields())
                .map(Field::hashCode)
                .reduce(Integer::sum)
                .orElse(super.hashCode());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Entity) {
            return Arrays.equals(((Entity) obj).toStringsArray(), this.toStringsArray());
        } else {
            return super.equals(obj);
        }

    }

    public boolean compareById(Long id) {

        Field myId;

        try {

            myId = getClass().getDeclaredField("id");
            myId.setAccessible(true);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return false;
        }

        try {
            return (myId != null) && myId.getLong(this) == id;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }

    }

    public <T extends Entity> boolean compareById(T entity) {

        if (getClass().getDeclaredFields().length != entity.getClass().getDeclaredFields().length) {
            return false;
        }

        long id;

        try {
            Field f = entity.getClass().getDeclaredField("id");
            f.setAccessible(true);
            id = f.getLong(entity);
        } catch (IllegalAccessException | NoSuchFieldException | NullPointerException e) {
            e.printStackTrace();
            return false;

        }

        return compareById(id);

    }


}
