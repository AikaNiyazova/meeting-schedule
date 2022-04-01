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
        return memberType.getCode();
    }

    @Override
    public MemberType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(MemberType.values())
                .filter(memberType -> memberType.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
