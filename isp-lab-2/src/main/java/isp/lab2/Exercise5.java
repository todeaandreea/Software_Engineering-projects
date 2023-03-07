package isp.lab2;

import java.util.Random;

public class Exercise5 {
    public static int rand(Random n) {
        int l = -1000;
        int h = 1000;
        int rez = n.nextInt(h - l) + l;
        return rez;
    }

    public static void generare(int[] v, Random n){
        for (int i=0; i<v.length;i++){
            v[i]=rand(n);
            System.out.print(v[i]+" ");
        }
    }

    public static void sortare(int[] v){
        int aux;
        for(int i=0;i<v.length-1;i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i] > v[j]) {
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }
        for (int i=0; i<v.length;i++){
            System.out.print(v[i]+" ");
        }
    }
    public static void main(String[] args){
        int[] v = new int[20];
        Random n=new Random();

        System.out.println("Vectorul generat este: ");
        generare(v,n);

        System.out.println();
        System.out.println("Vectorul sortat este: ");
        sortare(v);

    }

}
