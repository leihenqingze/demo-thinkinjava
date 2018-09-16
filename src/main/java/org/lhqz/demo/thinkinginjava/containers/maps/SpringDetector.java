package org.lhqz.demo.thinkinginjava.containers.maps;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.lhqz.demo.tools.Print.*;

public class SpringDetector {

    public static <T extends Groundhog> void detectorSpring(Class<T> type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog, Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i), new Prediction());
        }
        println("map = " + map);
        Groundhog gh = ghog.newInstance(3);
        println("Looking up prediction for " + gh);
        if (map.containsKey(gh)) {
            println(map.get(gh));
        } else {
            println("Key not found: " + gh);
        }
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        detectorSpring(Groundhog.class);
    }

}