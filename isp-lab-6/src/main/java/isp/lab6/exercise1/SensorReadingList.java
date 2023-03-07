package isp.lab6.exercise1;



import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SensorReadingList implements IReadingRepository{
    private List<SensorReading> sensorList=new ArrayList<SensorReading>();

    public void addReading(SensorReading reading){
        sensorList.add(reading);

    }
    public double getAvarageValueByType(Type type, String location){
        int s=0; int k=0; double ma=0;
        for(SensorReading i:sensorList){
            if ((type==i.getType()) && (location.equals(i.getLocation()))) {
                s += i.getValue();
                k++;
            }
        }
        ma=(double)s/k;
        return ma;
    }
    public List<SensorReading> getReadingsByType(Type type){
        List<SensorReading> sensorList2=new ArrayList<SensorReading>();
        for(SensorReading i:sensorList ){
            if (type==i.getType()) sensorList2.add(i);
        }
        return sensorList2;
    }


    public void listSortedByLocation(){

        sensorList.sort((o1, o2) -> {
           return Integer.valueOf(o1.getLocation().compareTo(o2.getLocation()));

        });
        System.out.println("Sorted list by location: ");
        for(SensorReading i:sensorList ){
        System.out.println(i);}
    }

    public void listSortedByValue(){

        sensorList.sort(Comparator.comparing(SensorReading::getValue));

        System.out.println("Sorted list by value: ");
        for(SensorReading i:sensorList ){
            System.out.println(i);}
    }
    public List<SensorReading> findAllByLocationAndType(String location, Type type){
        List<SensorReading> sensorList2=new ArrayList<SensorReading>();
        for(SensorReading i:sensorList ){
            if ((type==i.getType()) && (location.equals(i.getLocation())))  sensorList2.add(i);
        }
        return sensorList2;

    }

}
