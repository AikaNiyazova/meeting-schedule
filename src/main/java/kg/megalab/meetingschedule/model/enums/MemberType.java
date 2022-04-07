package kg.megalab.meetingschedule.model.enums;

public enum MemberType {

    ORGANIZER("ORGANIZER"),
    INVITED_PARTICIPANT("INVITED_PARTICIPANT"),
    DELEGATE("DELEGATE");

    private final String value;

    MemberType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
