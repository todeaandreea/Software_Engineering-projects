package isp.lab3.exercise1;

public class TreeTest {
    public static void main(String[] args) {
        Tree t1 = new Tree();


        t1.grow(-3);
        System.out.println(t1.toString());
        t1.grow(45);
        System.out.println(t1.toString());
        t1.grow(100);
        System.out.println(t1.toString());


    }
}
