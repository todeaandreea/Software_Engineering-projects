package isp.lab4.exercise3;


import isp.lab4.exercise1.TemperatureSensor;
import isp.lab4.exercise2.FireAlarm;
import junit.framework.TestCase;



public class ControlerTest extends TestCase {

    public TemperatureSensor sensor;
    public FireAlarm fa;
    public Controler c;

    public void setUp(){

        sensor=new TemperatureSensor(55,"Cluj");
        fa=new FireAlarm(false);

        c = new Controler(sensor,fa);



    }

    public void testControlStep(){
        c.controlStep();
        assertTrue(fa.isActive());
    }

}
