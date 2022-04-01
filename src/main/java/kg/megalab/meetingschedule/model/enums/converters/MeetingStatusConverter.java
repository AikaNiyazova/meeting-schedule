package kg.megalab.meetingschedule.model.enums.converters;

import kg.megalab.meetingschedule.model.enums.MeetingStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class MeetingStatusConverter implements AttributeConverter<MeetingStatus, String> {

    @Override
    public String convertToDatabaseColumn(MeetingStatus meetingStatus) {
        if (meetingStatus == null) {
            return null;
        }
        return meetingStatus.getCode();
    }

    @Override
    public MeetingStatus convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(MeetingStatus.values())
                .filter(meetingStatus -> meetingStatus.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
