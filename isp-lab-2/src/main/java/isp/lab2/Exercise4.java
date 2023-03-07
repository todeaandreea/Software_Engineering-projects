package isp.lab2;

public class Exercise4 {
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

    public static boolean par(int x){
        if (x%2==0) return true;
        else return false;
    }

    public static boolean impar(int x){
        if (x%2!=0) return true;
        else return false;
    }

    public static void testarePrim(int[] v){
        for (int i=0; i<v.length; i++){
            if (prim(v[i])) {
                System.out.println("Primul numar prim este "+v[i]+" si se afla pe pozitia "+i);
                break;
            }
        }
    }

    public static void testarePar(int[] v){
        for (int i=0; i<v.length; i++){
            if (par(v[i])) {
                System.out.println("Primul numar par este "+v[i]+" si se afla pe pozitia "+i);
                break;
            }
        }
    }

    public static void testareImpar(int[] v){
        for (int i=0; i<v.length; i++){
            if (impar(v[i])) {
                System.out.println("Primul numar impar este "+v[i]+" si se afla pe pozitia "+i);
                break;
            }
        }
    }



    public static void main(String[] args){
        int[] v={1,3,7,8,2};
        testarePrim(v);
        testarePar(v);
        testareImpar(v);


    }
}
