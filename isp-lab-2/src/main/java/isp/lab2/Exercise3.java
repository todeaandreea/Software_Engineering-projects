package isp.lab2;

import java.util.Scanner;

public class Exercise3 {
    public static int suma(int x){
        int s=0;
        while(x%10!=0){
            s+=x%10;
            x=x/10;
        }
        return s;
    }

    public static boolean prim(int nr)
    {
        if (nr <= 1) return false;
        else
        if (nr == 2) return true;
        else if (nr % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(nr); i += 2)
        {
            if (nr % i == 0) return false;
        }
        return true;
    }

    public static int cifrePare(int n, int[] v){
        int cpare=0;

        for(int j=0;j<n;j++){
            if (suma(v[j])%2==0) cpare++;
        }
        return cpare;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] v=new int[200];
        System.out.println("Introduceti limita inferioara si limita superioara a intervalului");
        int A=sc.nextInt();
        int B= sc.nextInt();
        System.out.println("Numarul numerelor pentru care se va face suma cifrelor ");
        int n= sc.nextInt();
        int p=1;  int j=0;
        int k=0;
        float mg=0;


        for(int i=A; i<=B; i++) {
            if (prim(i)) {
                p*=i;
                k++;
                if (k<=n) {
                    v[j]=i;
                    j++;
                }
            }

        }
        mg=(float)Math.pow(p, 1.0/k);


        System.out.println("Media geometrica a numerelor prime din interval este:" );
        System.out.println(mg);
        System.out.println("Numarul numerelor primelor "+n+ " numere prime cu suma cifrelor pare este "+cifrePare(n,v));


    }

}
