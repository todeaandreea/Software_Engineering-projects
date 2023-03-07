/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isp.lab8.carparkaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author mihai.hulea
 */
public class ParkingAccessControl {

    public static final int MAX_CAPACITY = 5;
    
    private ArrayList<Car>  parkedCars = new ArrayList<>();
   
    private ArrayList<Car>  previousCars = new ArrayList<>();

    private int capacity=0;
    private long time=0;
    private double price;
    private double currentCost;

    private boolean isFull() {
        return this.capacity >= MAX_CAPACITY;
    }

    public void setParkedCars(ArrayList<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void carEntry(Car car){
        //1. sa verific capacitatea
        //2. daca capacitatea este depasita -> return
        if (this.isFull()) return;
        this.capacity++;
        //3. verific daca nu cumva masina este deja in parcare, si daca este -> return
        for(Car pc:parkedCars){
            if (pc.getPlateNumber().equals(car.getPlateNumber())) return;
        }
        //4. daca masina nu este in parcare salvez obiectul de tip car in parkedCars
        this.parkedCars.add(car);
        System.out.println("Car "+car+" is entering car park!");
    }
    
    public int carExit(String plateNumber){
        //1. cautam dupa plate number un Car in parkedCars
        //2. daca nu am gasit plateNumber -> return 
        //3. daca am gasit masina, 
            //calculez timpul de asteptare in parcare, -> System.currentTimeMiliseconds()
            //calculez pretul, 
            //sterg masina din parkedCars si o adaug in previousCars
            //returnez pretul
        for(Car pc:parkedCars){
            if (pc.getPlateNumber().equals(plateNumber)) {
                time=(System.currentTimeMillis()-pc.getEntryTime())/1000;
                pc.setTotalStay(time);
                price=(int)time;
                pc.setTotalPrice((int)price);
                parkedCars.remove(pc);
                this.capacity--;
                this.previousCars.add(pc);
                System.out.println("Car with plate number "+plateNumber+" is exiting");
                return (int)price;
            }
        }

        return 1;
    }
    
    public void viewCurrentCars(){
        System.out.println("Display all parked cars.");
        for(Car pc:parkedCars){
            System.out.println(pc.toString());
            currentCost=(int)(System.currentTimeMillis()-pc.getEntryTime())/1000;
            System.out.println("Current cost is:"+currentCost);

        }
        System.out.print("Available free spaces:");
        System.out.print(MAX_CAPACITY-this.capacity);
        System.out.println();
    }
    
    public void viewPastEntriesForCar(String plateNumber){
        double s=0;
        System.out.println("Display all past entries for a car.");
        for(Car pc:previousCars){
          if (pc.getPlateNumber().equals(plateNumber)) {
                System.out.println(pc.toString());
                System.out.println("Total price for this car is: "+pc.getTotalPrice()+" RON");
                System.out.println("Total stay for this car is: "+pc.getTotalStay()+" seconds");
                s+=pc.getTotalPrice();
            }
        }
        System.out.println();
        System.out.println("Total cost for all stays:"+s+" RON");

    }
    
    public void viewPastUniqueEntries(String plateNumber){
        Predicate<Car> byPlateNumber = car -> car.getPlateNumber().equals(plateNumber);

       long result = previousCars.stream().filter(byPlateNumber).collect(Collectors.toList()).stream().count();
       if (result==0) System.out.println(plateNumber + ": This car has never entered");
       else if (result==1) System.out.println(plateNumber+": This car has a unique entry");
       else System.out.println(plateNumber+": This car has "+result+" entries");


    }
    
}
