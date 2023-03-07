package isp.lab3.exercise6;

import java.util.Scanner;

public class VendingMachine {
    private static VendingMachine Instance;
    private int credit;
    private String[] products;

    private VendingMachine(int credit, String[] products) {
        this.credit = credit;
        this.products = products;
    }

    public static VendingMachine getInstance() {
        if (Instance == null) {
            String[] products = {"Oreo", "Cafea", "Ceai"};
            Instance = new VendingMachine(500, products);

        }
        return Instance;
    }

    public void displayProducts() {
        System.out.println("Produsele aflate pe stoc cu id-ul corespunzator: ");
        for (int i = 0; i < products.length; i++) {
            System.out.print(i + " " + products[i]);
            System.out.println();
        }
    }

    public void insertCoins(int value) {
        this.credit += value;
    }

    public String selectProduct(int id) {
        for (int i = 0; i < products.length; i++) {
            if (id == i) return products[i];
        }
        return "Nu exista";
    }

    public void displayCredit() {
        System.out.println("Creditul activ este " + this.credit);
    }

    public void userMenu() {

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1:Afisare produse");
            System.out.println("2:Selectare produs");
            System.out.println("3:Introducere credit");
            System.out.println("4:Afisare credit");
            System.out.println("5:Iesire");

            String optiuni = s.nextLine();

            switch (optiuni) {
                case "1":
                    this.displayProducts();
                    break;

                case "2":
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Introduceti id-ul produsului: ");
                    int n = scanner1.nextInt();
                    System.out.println("Produsul ales: " + this.selectProduct(n));
                    break;

                case "3":
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Introduceti creditul care sa fie adaugat: ");
                    n = scanner2.nextInt();
                    this.insertCoins(n);
                    break;

                case "4":
                    this.displayCredit();
                    break;

                case "5":
                    s.close();
                    break;

            }
        }
    }


}
