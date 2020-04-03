package ru.sfedu.pKino.repository.interfaces;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CsvSerializer {


    static <T extends Entity> String[] serialize(T entity) {

        String[] data           = entity.toStringsArray();
        String[] serializedData = new String[data.length + 1];

        System.arraycopy(data, 0, serializedData, 1, data.length);

        serializedData[0] = entity.getClass().getName();

        return serializedData;

    }

    static <T extends Entity> List<String[]> serializeAll(List<T> entities) {
        return entities.stream().map(CsvSerializer::serialize).collect(Collectors.toList());
    }


    static <T extends Entity> T deserialize(String[] serializedData) {

        String   className = serializedData[0];
        String[] data      = Arrays.copyOfRange(serializedData, 1, serializedData.length);
        T        newEntity = null;

        try {
            Class c = Class.forName(className);
            newEntity = (T) c.getConstructors()[0].newInstance();

            if (newEntity == null) {
                throw new NullPointerException("New object is null!");
            }

            boolean flag = false;

            for (Method declaredMethod : Class.forName(className).getMethods()) {
                if (declaredMethod.getName().contains("updateFromStrings")) {
                    declaredMethod.invoke(newEntity, (Object) data);
                    flag = true;
                }
            }
            if (!flag) {
                throw new ClassNotFoundException("Cannot deserialize data!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return newEntity;

    }


}
