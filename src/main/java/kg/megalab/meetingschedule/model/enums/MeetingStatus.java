package kg.megalab.meetingschedule.model.enums;

public enum MeetingStatus {

    IN_PROGRESS("PRO"),
    COMPLETED("COM"),
    CANCELED("CAN"),
    RESCHEDULED("RES");

    private final String code;

    MeetingStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
