package org.lhqz.demo.thinkinginjava.innerclasses;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            //创建一个拷贝，方便后面进行移除
            for (Event e : new ArrayList<>(eventList)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
