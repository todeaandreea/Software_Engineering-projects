package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

enum SensorType{
    TEMP, PRES;
}
/////////////////////////////////////////
class SensorReading implements Comparable<SensorReading>{
    double value;
    long dateAndTime;

    public SensorReading(double value, long dateAndTime) {
        this.value = value;
        this.dateAndTime = dateAndTime;
    }

    @Override
    public int compareTo(SensorReading o) {
        return (int)(value-o.value);
    }
}
/////////////////////////////////////////
class Sensor implements Comparator<SensorReading>{
    ArrayList<SensorReading> readings = new ArrayList<>();
    String id;
    SensorType type;

    public int compare(SensorReading s1,SensorReading s2){
       if (s1.dateAndTime < s2.dateAndTime) return -1;
        if (s1.dateAndTime > s2.dateAndTime) return 1;
       else return 0;
   }

    public Sensor(String id, SensorType type) {
        this.id = id;
        this.type = type;
    }

    public boolean addSensorReading(SensorReading reading){
        readings.add(reading);
        return true;
    }

    List<SensorReading> getSensorReadingSortedByValue(){
        Collections.sort(readings); //aceasta metoda utilizeaaz criteriul definiti in compareTo din clasa SensorReading)
        return readings;
    }

    List<SensorReading> getSensorReadingSortedByDate(Sensor s){
        Collections.sort(readings,s); //aceasta metoda utilizeaaz criteriul definiti in compareTo din clasa SensorReading)
        return readings;
    }

    List<SensorReading> getReadings(){
        return readings;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "readings=" + readings +
                ", id='" + id + '\'' +
                ", type=" + type +
                '}';
    }
}
/////////////////////////////////////////
class SensorCluster{
    ArrayList<Sensor> sensors = new ArrayList<>();


    public Sensor addSensor(String id, SensorType type){
        if (this.sensors == null) {
            sensors = new ArrayList<>();
        }
        for(Sensor s: this.sensors) {
            if (s.id.equals(id)) return null;
        }
        Sensor sensor = new Sensor(id, type);
        this.sensors.add(sensor);
        return sensor;
    }

    public boolean writeSensorReading(String id, double value, long dtaeTime){
        for(Sensor s: sensors){
            if(s.id.equals(id)){
                s.addSensorReading(new SensorReading(value,dtaeTime));
            }
            else  return false;
        }
        return true;
    }

    public Sensor getSensorById(String id){
        return sensors.stream().filter(s -> s.id==id).findFirst().get();
    }

}
/////////////////////////////////////////
public class Exercise3 {

    public static void main(String[] args) {
        SensorCluster c = new SensorCluster();

        SensorCluster c1 = new SensorCluster();
        c.addSensor("1",SensorType.TEMP);
        c1.addSensor("2",SensorType.PRES);


        c.writeSensorReading("1",8,99);
        c.writeSensorReading("1",1,91);
        c.writeSensorReading("1",7,92);
        c.writeSensorReading("1",5,93);
        c.writeSensorReading("1",2,19);

        c1.writeSensorReading("2",3,76);
        c1.writeSensorReading("2",10,89);
        c1.writeSensorReading("2",1,54);
        c1.writeSensorReading("2",4,58);




        Sensor s1 = c.getSensorById("1");
        Sensor s2 = c1.getSensorById("2");
        List<SensorReading> rez1 = s1.getSensorReadingSortedByDate(s1);
        List<SensorReading> rez2 = s2.getSensorReadingSortedByValue();


        rez1.stream().forEach(s -> System.out.println(s.dateAndTime));
        rez2.stream().forEach(s -> System.out.println(s.value));

        Sensor sc = c.addSensor("4",SensorType.TEMP);
        if (sc==null) System.out.println("The sensor is "+sc+" because the id already exists");
        else System.out.println("The new sensor has the following data: "+sc.toString());

        System.out.println("The sensor has been found! "+c.writeSensorReading("4",5,77));

        //////////
//        for(SensorReading s: rez){
//            System.out.println(s.value);
//        }


    }
}
