package isp.lab9.exercise2;

public class HumiditySensor extends Sensor{
    @Override
    public int readSensor() {
        this.changeState("Humidity sensor, value: "+super.readSensor());
        return super.readSensor();
    }
}
