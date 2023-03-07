package isp.lab4.exercise3;

import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;

public class Exercise3 {
    public static void main(String[] args) {
        TemperatureSensor t=new TemperatureSensor(56,"Targu Mures");
        FireAlarm fa = new FireAlarm(false);
        Controler c=new Controler(t,fa);

        c.controlStep();

    }
}
