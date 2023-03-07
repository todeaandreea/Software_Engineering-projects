package isp.lab3.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
        MyPoint p1=new MyPoint(2,1,4);
        MyPoint p2=new MyPoint(5,0,2);

        System.out.println("Distanta dintre cele 2 puncte este "+p1.distance(p2));
    }
}
