package isp.lab4.exercise1;

import junit.framework.TestCase;

public class TemperatureSensorTest extends TestCase{
    //implement minimal tests
    public TemperatureSensor sensor;
    public void setUp(){
        sensor = new TemperatureSensor(30,"Timisoara");

    }

    public void testLocation(){
        assertEquals("Timisoara",sensor.getLocation());
    }

    public void testType(){
        assertTrue(30 == sensor.getValue());
    }

}
