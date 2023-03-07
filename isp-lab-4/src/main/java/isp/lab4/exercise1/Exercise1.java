package isp.lab4.exercise1;

//import isp.lab4.exercise0.CarAlarm; //NU ASA

public class Exercise1 {

    public static void main(String[] args) {
        //instantiati obiect
        TemperatureSensor t=new TemperatureSensor(6,"Sighisoara");
        System.out.println("In "+t.getLocation()+" temperatura este "+t.getValue());
    }

}
