package isp.lab3.exercise5;


public class Exercise5 {
    public static void main(String[] args) {

        String[] prod = {"Snickers", "Apa plata", "Servetele"};
        VendingMachine v1 = new VendingMachine(500, prod);
        v1.userMenu();
    }
}
