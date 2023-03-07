package isp.lab10.exercise1;

import static java.lang.Thread.sleep;

public class Aircraft implements Runnable{

    private AircraftState state;
    private boolean isLanded = false;
    private Long startCruisingTime;

    private String id;
    private int altitude;

    public Aircraft(String id) {
        this.id = id;
        this.state = AircraftState.ON_STAND;
    }

    public String getId() {
        return id;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void receiveAtcMessage(AtcCommand atcCommand){
        synchronized (this) {
            if (atcCommand instanceof TakeoffCommand) {
                if (state.equals(AircraftState.ON_STAND)) {

                    this.altitude = ((TakeoffCommand) atcCommand).getAltitude();
                    state = AircraftState.TAXING;
                    this.notify();

                } else {
                    System.out.println("Plane is not ON_STAND");
                }
            } else if (atcCommand instanceof LandCommand) {
                if (state.equals(AircraftState.CRUISING)) {

                    state = AircraftState.DESCENDING;
                    this.notify();

                } else {
                    System.out.println("Plane is not on CRUISING state");
                }
            } else {
                System.out.println("Bad command");
            }
        }
    }

    private void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void blockThread() {
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run(){
        while (!isLanded) {
            switch (state) {
                case ON_STAND: {
                    System.out.println("ON_STAND -> " + this);
                    blockThread();
                    break;
                }
                case TAXING: {
                    System.out.println("TAXING -> " + this);
                    sleep(10_000L);
                    state = AircraftState.TAKING_OFF;
                    break;
                }
                case TAKING_OFF: {
                    System.out.println("TAKING_OFF -> " + this);
                    sleep(5_000L);
                    state = AircraftState.ASCENDING;
                    break;
                }
                case ASCENDING: {
                    System.out.println("ASCENDING -> " + this);
                    System.out.println("Altitude: " + altitude * 1000);
                    for (int i = 0; i <= altitude; i++) {
                        sleep(10_000L);
                    }
                    state = AircraftState.CRUISING;
                    break;
                }
                case CRUISING: {
                    System.out.println("CRUISING -> " + this);
                    startCruisingTime = System.currentTimeMillis();
                    blockThread();
                    break;
                }
                case DESCENDING: {
                    System.out.println("DESCENDING -> " + this);
                    System.out.println("Altitude before descending: " + altitude * 1000);
                    while (altitude > 0) {
                        sleep(10_000L);
                        altitude--;
                    }
                    System.out.println("Altitude after descending: " + altitude * 1000);
                    state = AircraftState.LANDED;
                    break;
                }
                case LANDED: {
                    System.out.println("LANDED -> " + this);
                    System.out.println("Aircraft " + this.getId() + " spent " + (System.currentTimeMillis() - startCruisingTime) + " milliseconds in cruising mode");
                    isLanded = true;
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + state);
            }
        }
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id='" + id + '\'' +
                ", altitude=" + altitude +
                ", state=" + state +
                ", isLanded=" + isLanded +
                '}';
    }
}
