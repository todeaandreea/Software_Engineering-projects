package isp.lab8.carparkaccess;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import junit.framework.TestCase;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParkingAccessControlTest extends TestCase {
    public ParkingAccessControl pac,pac1;
    public ArrayList<Car> cars,cars1;
    public Gson gson,gson1;
    public Reader reader,reader1;
    public void setUp(){
        try {
           pac = new ParkingAccessControl();
            // create Gson instance
           gson = new Gson();

            // create a reader
             reader = Files.newBufferedReader(Paths.get("HistoryParkingFolder.json"));

            // convert JSON array to list of users
             cars = new Gson().fromJson(reader, new TypeToken<List<Car>>() {}.getType());
            pac.setParkedCars(cars);
            // print users
            cars.forEach(System.out::println);

            // close reader
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            pac1 = new ParkingAccessControl();
            // create Gson instance
            gson1 = new Gson();

            // create a reader
            reader1 = Files.newBufferedReader(Paths.get("CurrentParkingFolder.json"));

            // convert JSON array to list of users
            cars1 = new Gson().fromJson(reader1, new TypeToken<List<Car>>() {}.getType());
            pac1.setParkedCars(cars1);
            // print users
            cars1.forEach(System.out::println);

            // close reader
            reader1.close();
          //  TimeUnit.SECONDS.sleep(3);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void testCarExit() throws InterruptedException {
        assertNotSame(1,pac1.carExit(cars1.get(0).getPlateNumber()));
    }
    public void testViewPastEntriesForCar(){
        pac.viewPastEntriesForCar((cars.get(0).getPlateNumber()));
        assertEquals(3,cars.get(0).getTotalPrice());
        assertEquals(3,cars.get(0).getTotalStay());
    }

}
