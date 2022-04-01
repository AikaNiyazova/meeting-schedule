package kg.megalab.meetingschedule.model.enums;

public enum EmployeeStatus {

    ACTIVE("A"),
    ON_LEAVE("L"),
    BLOCKED("B"),
    DISMISSED("D");

    private final String code;

    EmployeeStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
