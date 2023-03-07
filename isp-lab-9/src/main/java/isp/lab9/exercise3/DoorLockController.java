package isp.lab9.exercise3;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class DoorLockController implements ControllerInterface {
    private Map<Tenant,AccessKey> validAccess;
    private Door door;
    private List<AccessLog> accessLogs;
    private int tries=0;

    private AccessLog createAccessLog(final String tenant, final String operation, final String errMessage) {
        return new AccessLog(tenant, LocalDateTime.now(), operation, this.door.getStatus(), errMessage);
    }

    public DoorLockController(Door door, List<AccessLog> accessLogs){
        this.door=door;
        this.accessLogs=accessLogs;
        this.validAccess = new HashMap<>();
        this.validAccess.put(new Tenant(ControllerInterface.MASTER_TENANT_NAME), new AccessKey(ControllerInterface.MASTER_KEY));
    }

    private boolean isPermanentlyLocked() {
        return this.tries >= 3;
    }

    @Override
    public DoorStatus enterPin(String pin) throws Exception{
        final Map.Entry<Tenant, AccessKey> accessKeyEntry = this.validAccess
                .entrySet().stream().filter(tenantAccessKeyEntry -> tenantAccessKeyEntry.getValue().getPin().equals(pin))
                .findAny().orElse(null);

        if (Objects.isNull(accessKeyEntry)) {
            tries ++;
            if (this.isPermanentlyLocked()) {
                this.tries = 3;
                this.accessLogs.add(this.createAccessLog("", "enter Pin", "TooManyAttemptsException"));
                throw new TooManyAttemptsException();
            } else {
                this.accessLogs.add(this.createAccessLog("", "enter Pin", "InvalidPinException"));
                throw new InvalidPinException();
            }
        } else
        {
            if (accessKeyEntry.getKey().getName().equals(ControllerInterface.MASTER_TENANT_NAME)) {
                this.tries = 0;
            } else if (this.isPermanentlyLocked()){
                this.accessLogs.add(this.createAccessLog("","enter Pin", "TooManyAttemptsException"));
                throw new TooManyAttemptsException();
            }

            if (door.getStatus() == DoorStatus.OPEN) {
                door.lockDoor();
            }
            else {door.unlockDoor();}

            this.accessLogs.add(this.createAccessLog("","enter Pin", ""));
            return door.getStatus();
        }
    }

    @Override
    public void addTenant(String pin,String tenantName) throws Exception {
        for (Map.Entry<Tenant,AccessKey> i : this.validAccess.entrySet()){
            if (i.getKey().getName().equals(tenantName)){
                this.accessLogs.add(this.createAccessLog(tenantName,"add tenant","TenantAlreadyExistsException"));
                throw new TenantAlreadyExistsException();
            }

        }
       Tenant t=new Tenant(tenantName);
        AccessKey accessKey=new AccessKey(pin);

        this.validAccess.put(t,accessKey);
        this.accessLogs.add(this.createAccessLog(tenantName,"add tenant",""));
    }
    @Override
    public void removeTenant(String name) throws Exception {
        int ok=0;
        for (Map.Entry<Tenant,AccessKey> i : this.validAccess.entrySet()) {
            if (i.getKey().getName().equals(name)) {
                this.validAccess.remove(i.getKey());
                this.accessLogs.add(this.createAccessLog(name, "remove tenant", ""));
                ok = 1;
            }
        }
        if (ok==0) {
            this.accessLogs.add(this.createAccessLog(name, "remove tenant", "TenantNotFoundException"));
            throw new TenantNotFoundException();
            }



    }
    public List<AccessLog> getAccessLogs(){
        return accessLogs;
    }


}
