package org.lhqz.demo.thinkinginjava.initandcleanup;

import lombok.Data;

import java.util.Date;

@Data
class Rock {

    private String rock;
    private Date date;

    public Rock(){
        System.out.println("Rock " + rock);
    }

    public Rock(int i){
        System.out.println("Rock " + i);
    }

    public Rock(String rock){
        this.rock = rock;
        System.out.println("Rock " + rock);
    }

    public Rock(Date date){
        date.setYear(2017);
        this.date = date;
        System.out.println("Rock " + date);
    }

}

public class SimpleConstructor {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Rock();
            new Rock(i);
            new Rock("rock");
        }

        Date date = new Date();
        System.out.println(date.getTime());
        Rock rock = new Rock(date);
        System.out.println(date.getTime());
        System.out.println(date == rock.getDate());
    }

}
