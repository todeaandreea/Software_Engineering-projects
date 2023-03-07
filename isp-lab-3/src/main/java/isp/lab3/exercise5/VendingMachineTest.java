package isp.lab3.exercise5;

import java.util.Scanner;

public class VendingMachineTest {
    public static void main(String[] args) {
        String[] prod = {"Bounty", "Apa minerala", "Burger", "Chips"};
        Scanner s = new Scanner(System.in);

        VendingMachine v1 = new VendingMachine(500, prod);

        v1.displayProducts();

        System.out.println("Selectati id-ul produsului dorit: ");
        int id = s.nextInt();
        System.out.println("Produsul al carui id este " + id + ":" + v1.selectProduct(id));

        System.out.println("Selectati creditul care doriti sa fie adaugat: ");
        int crd = s.nextInt();
        v1.insertCoins(crd);
        v1.displayCredit();
    }
}
