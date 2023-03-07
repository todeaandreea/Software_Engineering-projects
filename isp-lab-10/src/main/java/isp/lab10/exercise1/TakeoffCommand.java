package isp.lab10.exercise1;

public class TakeoffCommand extends AtcCommand{
    private int altitude;

    public TakeoffCommand(int altitude) {
        this.altitude = altitude;
    }

    public int getAltitude() {
        return altitude;
    }
}
