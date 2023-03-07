package isp.lab4.exercise5;


public class Exercise5 {
    public static void main(String[] args) {
    Controler c=new Controler();

    House h=new House(c);
    h.getControler().controlStep();

}
}
