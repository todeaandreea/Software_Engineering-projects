package isp.lab2;

import java.util.Scanner;

public class Exercise6 {
    public static void nerecursiv(int[] v, int n){
        int x1 = 1; v[0]=1;
        int x2 = 2; v[1]=2;

        for (int i = 2; i < n; i++) {
            v[i] = x1 * x2;
            x1 = x2;
            x2 = v[i];
        }

        for(int i=0; i<v.length;i++){
            System.out.print(v[i]+" ");
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti un numar >=8: ");
        int n = sc.nextInt();
        int[] v = new int[n];

        System.out.println("Vectorul prin metoda nerecursiva este: ");
        nerecursiv(v,n);
        System.out.println();
        System.out.println("Vectorul prin metoda recursiva este: ");


    }

}
