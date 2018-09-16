package org.lhqz.demo.thinkinginjava.innerclasses;

/**
 * 控制框架的完整实现是由单个的类创建的，从而使得实现的细节被封装了起来。内部类用来表示解决问题所必需的各种不同的action()
 * 内部类能够很容易地访问外围类的任意成员，所以可以避免这种实现变的笨拙。
 */
public class GreenhouseControls extends Controller {

    private boolean light = false;

    public class LightOn extends Event {

        public LightOn(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {

        public LightOff(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {

        public WaterOn(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {

        public WaterOff(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is Off";
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event {

        public ThermostatNight(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {

        public ThermostatDay(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class Bell extends Event {

        public Bell(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(dealyTime));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {

        private Event[] eventList;

        public Restart(long dealyTime, Event[] eventList) {
            super(dealyTime);
            this.eventList = eventList;
            for (Event e : eventList) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restarting System";
        }
    }

    public static class Terminate extends Event {

        public Terminate(long dealyTime) {
            super(dealyTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

}
