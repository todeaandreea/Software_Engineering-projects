package isp.lab3.exercise3;

public class Exercise3 {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Porsche", "Taycan", 500, 'D');
        Vehicle v2 = new Vehicle("Dacia", "Duster", 175, 'B');


        v1.setFuelType('B');
        System.out.println(v1.getFuelType());

        v1.setModel("Toyota");
        System.out.println(v1.getModel());

        v1.setType("Corolla");
        System.out.println(v1.getType());

        v2.setSpeed(160);
        System.out.println(v2.getSpeed());

        System.out.println("Sunt cele 2 vehicule egale ? " + v1.equals(v1, v2));

        System.out.println("Numarul de vehicule este " + Vehicle.getNumberOfVehicles());


    }

}
