package isp.lab7.safehome;

public class Door {
    private DoorStatus status;

    public Door(){
    }

    public DoorStatus getStatus() {
        return status;
    }

    public void lockDoor(){
        this.status=DoorStatus.CLOSE;
    }

    public void unlockDoor(){
        this.status=DoorStatus.OPEN;
    }

}
