package isp.lab4.exercise5;


import junit.framework.TestCase;

public class ControlerTest extends TestCase {


    public Controler c;

    public void setUp(){

        c=new Controler();
    }

    public void testControlStep(){
        c.controlStep();
        assertTrue(c.getFireAlarm().isActive());
    }


}
