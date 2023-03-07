package isp.lab9.exercise2;

public class TemperatureSensor extends Sensor{
    @Override
    public int readSensor() {
        this.changeState("Temperature sensor, value: "+super.readSensor());
        return super.readSensor();
    }
}
