package kg.megalab.meetingschedule.model.enums.converters;

import kg.megalab.meetingschedule.model.enums.MemberType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class MemberTypeConverter implements AttributeConverter<MemberType, String> {

    @Override
    public String convertToDatabaseColumn(MemberType memberType) {
        if (memberType == null) {
            return null;
        }
        return memberType.getValue();
    }

    @Override
    public MemberType convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(MemberType.values())
                .filter(memberType -> memberType.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
