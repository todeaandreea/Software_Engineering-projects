package isp.lab2;

import java.util.Random;
import java.util.Scanner;

public class Exercise1 {
    public static int rand(Random n) {
        int l = 2;
        int h = 10;
        int rez = n.nextInt(h - l) + l;
        return rez;

    }

    public static void citire(int rez) {
        int[] v = new int[rez];
        int s=0;
        float ma=0;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < v.length; i++) {
            System.out.print("Elementul v["+i+"] este:"+" ");
            v[i] = sc.nextInt();
            s=s+v[i];
        }
        ma=(float)s/rez;
        System.out.println("Media aritmetica este "+ ma);

    }


    public static void main(String[] args) {
        Random n = new Random();
        int rez = rand(n);
        System.out.println("Numarul generat este " + rez);
        citire(rez);


    }
}
