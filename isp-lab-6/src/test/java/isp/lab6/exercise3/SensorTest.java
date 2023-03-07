package isp.lab6.exercise3;

import junit.framework.TestCase;


import java.util.ArrayList;
import java.util.List;

public class SensorTest extends TestCase {

    public Sensor sensor;
    public  SensorReading sensorReading1;
    public  SensorReading sensorReading2;

//    public SensorCluster c;
//    public SensorCluster c1;
//    public Sensor s1;
//    public Sensor s2 ;
//
//    public List<SensorReading> rez1;
//    public List<SensorReading> rez2;

    public void setUp(){
        sensor=new Sensor("2",SensorType.PRES);


        sensorReading1=new SensorReading(57,76);
        sensorReading2=new SensorReading(100,90);
//        c= new SensorCluster();
//        c1= new SensorCluster();
//
//        c.writeSensorReading("1",8,99);
//        c.writeSensorReading("1",1,91);
//        c.writeSensorReading("1",7,92);
//
//        c1.writeSensorReading("1",1,91);
//        c1.writeSensorReading("1",7,92);
//        c1.writeSensorReading("1",8,99);
//
//        s1= c.getSensorById("1");
//        s2= c1.getSensorById("1");
//
//        rez1=s1.getSensorReadingSortedByValue();
//        rez2=s2.getReadings();
    }

    public void testCompare(){
        assertEquals(-1,sensor.compare(sensorReading1,sensorReading2));
    }

//    public void testGetSensorReadingSortedByValue(){
//
//        assertEquals(rez2,rez1);
//    }
}
