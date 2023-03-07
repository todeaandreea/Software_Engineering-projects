package isp.lab6.exercise1;

public class SensorReading {
    private int value;
    private String location;
    private Type type;

    public SensorReading(int value, String location, Type type) {
        this.value = value;
        this.location = location;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public String getLocation() {
        return location;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "value=" + value +
                ", location='" + location + '\'' +
                ", type=" + type +
                '}';
    }

    public int compareTo(SensorReading reading){
        return getLocation().compareTo(reading.getLocation());
    }


}
