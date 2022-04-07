package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.MeetingDto;
import org.springframework.stereotype.Service;

@Service
public interface MeetingService {

    MeetingDto create(MeetingDto meetingDto); //TODO: CreateMeetingRequest request

    MeetingDto findById(Long id);

    MeetingDto update(MeetingDto meetingDto);

    MeetingDto save(MeetingDto meetingDto);

}
