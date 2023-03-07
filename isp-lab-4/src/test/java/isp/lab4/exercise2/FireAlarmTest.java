package isp.lab4.exercise2;

import isp.lab4.exercise1.TemperatureSensor;
import junit.framework.TestCase;

public class FireAlarmTest extends TestCase {

    public FireAlarm fa;
    public void setUp(){
        fa = new FireAlarm(true);

    }

    public void testIsActive(){
        assertEquals(true,fa.isActive());
    }



}
