package isp.lab2;

import java.util.Scanner;

/**
 * Check readme.md file for the exercise requirements.
 *
 * @author Radu Miron
 */
public class Exercise2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti cuvintele separate prin virgula: ");
        String s=sc.nextLine();
        System.out.println("Introduceti litera cu care sa inceapa cuvintele pe care le vizualizati ");
        char letter=sc.next().charAt(0);

        String[] parts = s.split(",");

        for (int i=0; i<parts.length; i++ ){
            if (parts[i].charAt(0)==letter)
                System.out.print("Cuvintele care incep cu litera aleasa este "+parts[i]+" ");
        }


    }

}
