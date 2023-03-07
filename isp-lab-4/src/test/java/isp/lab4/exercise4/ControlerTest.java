package isp.lab4.exercise4;

import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;
import junit.framework.TestCase;

public class ControlerTest extends TestCase {
    public TemperatureSensor[] temperatureSensors;
    public FireAlarm fa;
    public Controler c;

    public void setUp(){
        temperatureSensors=new TemperatureSensor[3];
        temperatureSensors[0]=new TemperatureSensor(55,"Sighisoara");
        temperatureSensors[1]=new TemperatureSensor(54,"Iclod");
        temperatureSensors[2]=new TemperatureSensor(57,"Targu Lapus");

        fa = new FireAlarm(false);
        c=new Controler(temperatureSensors,fa);


    }

    public void testControlStep(){
        c.controlStep();
        assertTrue( fa.isActive());
    }

}
