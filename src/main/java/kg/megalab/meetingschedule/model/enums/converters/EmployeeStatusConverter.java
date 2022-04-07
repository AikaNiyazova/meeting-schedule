package kg.megalab.meetingschedule.model.enums.converters;

import kg.megalab.meetingschedule.model.enums.EmployeeStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, String> {

    @Override
    public String convertToDatabaseColumn(EmployeeStatus employeeStatus) {
        if (employeeStatus == null) {
            return null;
        }
        return employeeStatus.getValue();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(EmployeeStatus.values())
                .filter(employeeStatus -> employeeStatus.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
