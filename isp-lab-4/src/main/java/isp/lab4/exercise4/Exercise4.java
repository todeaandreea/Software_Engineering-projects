package isp.lab4.exercise4;

import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;


public class Exercise4 {
    public static void main(String[] args) {
        TemperatureSensor[] temperatureSensors=new TemperatureSensor[3];
        temperatureSensors[0]=new TemperatureSensor(55,"Sighisoara");
        temperatureSensors[1]=new TemperatureSensor(54,"Iclod");
        temperatureSensors[2]=new TemperatureSensor(57,"Targu Lapus");


        FireAlarm fa = new FireAlarm(false);
       Controler c=new Controler(temperatureSensors,fa);
       c.controlStep();

    }
}
