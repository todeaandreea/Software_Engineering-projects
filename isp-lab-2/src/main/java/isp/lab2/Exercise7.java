package isp.lab2;

import java.util.Random;
import java.util.Scanner;

public class Exercise7 {
    public static int rand(Random n) {
        int l = 2;
        int h = 100;
        int rez = n.nextInt(h - l) + l;
        return rez;

    }
    public static void guessSecretNumber(int x){
        int k=0;

        Scanner sc= new Scanner(System.in);
        int[] v=new int[100];

        for(int i=0;i<99;i++){
            int y = sc.nextInt();
            v[i]=y;
            if(v[i]==x){
                System.out.println("Raspuns corect");
                k++;
                break;
            }
            else{
                if(v[i]<x){
                    System.out.println("Raspuns incorect, numarul este prea mic");
                    k++;

                }
                if(v[i]>x){
                    System.out.println("Raspuns incorect, numarul este prea mare");
                    k++;
                }
            }
        }

        int aux=k;
        for(int i=0;i<k;i++){
            if (v[i]==v[i+1])
                aux--;
        }
        System.out.println("Ati avut "+aux+" incercari");

    }
    public static void main(String[] args) {
        Random nrsecret= new Random();
        int n=rand(nrsecret);
        System.out.println("Ghiciti numarul :)");
        guessSecretNumber(n);

    }

}
