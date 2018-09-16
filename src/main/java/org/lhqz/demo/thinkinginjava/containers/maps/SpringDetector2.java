package org.lhqz.demo.thinkinginjava.containers.maps;

import java.lang.reflect.InvocationTargetException;

public class SpringDetector2 {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        SpringDetector.detectorSpring(Groundhog2.class);
    }

}