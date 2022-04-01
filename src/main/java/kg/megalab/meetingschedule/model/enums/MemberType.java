package kg.megalab.meetingschedule.model.enums;

public enum MemberType {

    ORGANIZER("O"),
    INVITED_PARTICIPANT("IP"),
    DELEGATE("D");

    private final String code;

    MemberType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
