package isp.lab6.exercise3;

import junit.framework.TestCase;

public class SensorReadingTest extends TestCase {
    public  SensorReading sensorReading1;
    public  SensorReading sensorReading2;

    public void setUp(){

        sensorReading1=new SensorReading(57,76);
        sensorReading2=new SensorReading(58,90);


    }

    public void testCompareTo(){assertEquals(-1,sensorReading1.compareTo(sensorReading2));}
}
