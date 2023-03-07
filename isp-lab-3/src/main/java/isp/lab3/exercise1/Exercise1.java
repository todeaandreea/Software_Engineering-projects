package isp.lab3.exercise1;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Tree t1 = new Tree();

        System.out.println("Meters: ");
        int m = s.nextInt();
        t1.grow(m);

        System.out.println(t1.toString());

    }
}
