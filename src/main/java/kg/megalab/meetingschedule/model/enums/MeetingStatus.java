package kg.megalab.meetingschedule.model.enums;

public enum MeetingStatus {

    FORTHCOMING("FORTHCOMING"),
    IN_PROGRESS("IN_PROGRESS"),
    COMPLETED("COMPLETED"),
    CANCELED("CANCELED"),
    RESCHEDULED("RESCHEDULED");

    private final String value;

    MeetingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
