package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.MeetingEmployeeDto;
import org.springframework.stereotype.Service;

@Service
public interface MeetingEmployeeService {

    MeetingEmployeeDto create(MeetingEmployeeDto meetingEmployeeDto); //TODO: CreateMeetingEmployeeRequest request ???

    MeetingEmployeeDto findById(Long id);

    MeetingEmployeeDto update(MeetingEmployeeDto meetingEmployeeDto);

    MeetingEmployeeDto save(MeetingEmployeeDto meetingEmployeeDto);

}
