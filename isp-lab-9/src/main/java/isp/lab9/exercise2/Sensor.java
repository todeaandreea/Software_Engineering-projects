package isp.lab9.exercise2;

import java.util.Random;

public class Sensor extends Observable {
    public int readSensor(){
        int min = 1;
        int max = 40;
        Random random=new Random();
        int value=random.nextInt(max+min)+min;
        return value;
    }
}
