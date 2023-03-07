package isp.lab8.carparkaccess;
import com.google.gson.Gson;

import isp.lab8.carparkaccess.file.ParkingAccessFileControl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class CarParkingAccessApp {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("It works!");

        ParkingAccessControl pac = new ParkingAccessControl();

        Car c1 = new Car("CJ-01-AAA", System.currentTimeMillis());


        pac.carEntry(c1);
        TimeUnit.SECONDS.sleep(3);
        int price = pac.carExit("CJ-01-AAA");
        System.out.println("Price for parking is ="+price);
        System.out.println();

        Car c2 = new Car("CJ-01-AAA", System.currentTimeMillis()-6);
        pac.carEntry(c2);
        TimeUnit.SECONDS.sleep(5);



        int price1= pac.carExit("CJ-01-AAA");
        System.out.println("Price for parking is ="+price1);
        System.out.println();

        pac.viewCurrentCars();
        System.out.println();
        pac.viewPastEntriesForCar("CJ-01-AAA");
        System.out.println();
        pac.viewPastUniqueEntries("CJ-01-AAA");

        Car[] cars=new Car[]{ c1,c2};
        Writer writer = Files.newBufferedWriter(Paths.get("HistoryParkingFolder.json"));


        new Gson().toJson(cars, writer);
        writer.close();

        ////////////////////////////////

//        ParkingAccessFileControl fpac = new ParkingAccessFileControl();
//        Car c3 = new Car("CJ-02-AAA", System.currentTimeMillis());
//        Car c4 = new Car("CJ-02-BBB", System.currentTimeMillis());
//        Car c5 = new Car("CJ-02-CCC", System.currentTimeMillis());
//        fpac.carEntry(c5);
//        fpac.carEntry(c3);
//        fpac.carEntry(c4);

       // price = fpac.carExit("CJ-02-CCC");

       // System.out.println("Price to be payed = "+price);

        Car c3 = new Car("CJ-02-AAA", System.currentTimeMillis());
        Car c4 = new Car("CJ-02-BBB", System.currentTimeMillis());
        Car c5 = new Car("CJ-02-CCC", System.currentTimeMillis());

        pac.carEntry(c5);
        pac.carEntry(c3);
        pac.carEntry(c4);

        Car[] cars1=new Car[]{ c3,c4,c5};
        Writer writer1 = Files.newBufferedWriter(Paths.get("CurrentParkingFolder.json"));


        new Gson().toJson(cars1, writer1);
        writer1.close();
    }
}
