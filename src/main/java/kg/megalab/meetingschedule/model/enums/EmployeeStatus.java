package kg.megalab.meetingschedule.model.enums;

public enum EmployeeStatus {

    ACTIVE("ACTIVE"),
    ON_LEAVE("ON_LEAVE"),
    BLOCKED("BLOCKED"),
    DISMISSED("DISMISSED");

    private final String value;

    EmployeeStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
