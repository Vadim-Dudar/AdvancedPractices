package edu.naukma.theme15;

import java.lang.reflect.InvocationTargetException;

public class ServiceFactory {
    public static <T> T create(String className) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return (T) Class.forName(className).getDeclaredConstructor().newInstance();
    }
}
