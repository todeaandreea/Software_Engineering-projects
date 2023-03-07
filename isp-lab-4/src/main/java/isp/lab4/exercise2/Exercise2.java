package isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FireAlarm fa = new FireAlarm(false);
        fa.setActive(false);
        System.out.println("Starea alarmei: "+fa.isActive());
        System.out.println(fa.toString());
    }
}
