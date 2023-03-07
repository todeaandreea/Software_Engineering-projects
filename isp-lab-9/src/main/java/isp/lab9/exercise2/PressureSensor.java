package isp.lab9.exercise2;

public class PressureSensor extends Sensor{
    @Override
    public int readSensor() {
        this.changeState("Pressure sensor, value: "+super.readSensor());
        return super.readSensor();
    }
}
