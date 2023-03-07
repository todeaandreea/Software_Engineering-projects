package isp.lab6.exercise3;

import junit.framework.TestCase;



public class SensorClusterTest extends TestCase {
    public SensorCluster c;

    public Sensor sensor1;


    public void setUp(){
        c = new SensorCluster();
        c.addSensor("1",SensorType.PRES);

        sensor1=c.addSensor("1",SensorType.TEMP);


    }

    public void testWriteSensorReading(){

        assertTrue(c.writeSensorReading("1",20,78));
    }

    public void testAddSensor(){
        assertNull(sensor1);
    }

    public void testGetSensorById(){


        assertEquals(c.addSensor("3",SensorType.PRES),c.getSensorById("3"));

    }


}
