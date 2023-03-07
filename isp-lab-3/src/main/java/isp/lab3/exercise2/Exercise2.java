package isp.lab3.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        Rectangle r2 = new Rectangle(4, 6, "maro");

        System.out.println("Lungimea dreptunghiului este " + r2.getLength());
        System.out.println("Latimea dreptunghiului este " + r2.getWidth());
        System.out.println("Culoarea dreptunghiului este " + r2.getColor());
        System.out.println("Perimetrul dreptunghiului este " + r2.getPerimeter());
        System.out.println("Aria dreptunghiului este " + r2.getArea());

    }
}
