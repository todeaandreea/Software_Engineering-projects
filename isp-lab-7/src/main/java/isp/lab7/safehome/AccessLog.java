package isp.lab7.safehome;

import java.time.LocalDateTime;

public class AccessLog {

    private String tenantName;
    private LocalDateTime dateTime;
    private String operation;
    private DoorStatus status;
    private String errorMessage;

    public AccessLog(String tenantName, LocalDateTime dateTime, String operation, DoorStatus status, String errorMessage) {
        this.tenantName = tenantName;
        this.dateTime = dateTime;
        this.operation = operation;
        this.status = status;
        this.errorMessage = errorMessage;
    }
}
