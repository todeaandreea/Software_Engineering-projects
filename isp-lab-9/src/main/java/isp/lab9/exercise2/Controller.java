package isp.lab9.exercise2;

public class Controller implements Observer {
    @Override
    public void update(Object event) {
        System.out.println("Sensor type with his value: "+event.toString());

    }
}
