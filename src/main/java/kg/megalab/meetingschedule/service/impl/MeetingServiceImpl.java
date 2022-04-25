package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.EmployeeMapper;
import kg.megalab.meetingschedule.mapper.MeetingEmployeeMapper;
import kg.megalab.meetingschedule.mapper.MeetingMapper;
import kg.megalab.meetingschedule.mapper.RoomMapper;
import kg.megalab.meetingschedule.model.dto.EmployeeDto;
import kg.megalab.meetingschedule.model.dto.MeetingDto;
import kg.megalab.meetingschedule.model.dto.RoomDto;
import kg.megalab.meetingschedule.model.entity.Meeting;
import kg.megalab.meetingschedule.model.entity.MeetingEmployee;
import kg.megalab.meetingschedule.model.enums.MeetingStatus;
import kg.megalab.meetingschedule.model.enums.MemberType;
import kg.megalab.meetingschedule.model.request.CreateMeetingRequest;
import kg.megalab.meetingschedule.repository.MeetingRepository;
import kg.megalab.meetingschedule.service.EmployeeService;
import kg.megalab.meetingschedule.service.MeetingEmployeeService;
import kg.megalab.meetingschedule.service.MeetingService;
import kg.megalab.meetingschedule.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class MeetingServiceImpl implements MeetingService {

    private final MeetingRepository meetingRepository;
    private final RoomService roomService;
    private final EmployeeService employeeService;
    private final MeetingEmployeeService meetingEmployeeService;

    @Autowired
    public MeetingServiceImpl(MeetingRepository meetingRepository, RoomService roomService, EmployeeService employeeService, MeetingEmployeeService meetingEmployeeService) {
        this.meetingRepository = meetingRepository;
        this.roomService = roomService;
        this.employeeService = employeeService;
        this.meetingEmployeeService = meetingEmployeeService;
    }

    @Override
    public MeetingDto create(CreateMeetingRequest request) {

        RoomDto roomDto = roomService.findById(request.getRoomId()); //Сотрудник будет сам выбирать комнату или программа должна предлагать ему выбор из свободных на момент встречи?

        Map<Long, String> participantDetails = request.getParticipantDetails();
        Set<Long> employeeIds = participantDetails.keySet();
        employeeService.validateIds(employeeIds); // TODO: doesn't work
        
        if (request.getMeetingDate().isBefore(LocalDate.now())) {
            throw new RuntimeException("Meeting date should be no earlier than today");
        }
        if (request.getMeetingStartTime().isBefore(LocalTime.now())) {
            throw new RuntimeException("Meeting start time should be no earlier than now");
        }
        if (request.getMeetingEndTime().isBefore(request.getMeetingStartTime())) {
            throw new RuntimeException("Meeting end time should be no earlier than its start time");
        }

        Meeting meeting = Meeting
                .builder()
                .meetingTopic(request.getMeetingTopic())
                .description(request.getDescription())
                .meetingDate(request.getMeetingDate())
                .meetingStartTime(request.getMeetingStartTime())
                .meetingEndTime(request.getMeetingEndTime())
                .room(RoomMapper.INSTANCE.toEntity(roomDto))
                .meetingStatus(MeetingStatus.valueOf("FORTHCOMING"))
                .build();
        meetingRepository.save(meeting);

        for (Long id : employeeIds) {
            EmployeeDto employeeDto = employeeService.findById(id);
            String memberType = participantDetails.get(id);
            MeetingEmployee meetingEmployee = MeetingEmployee
                    .builder()
                    .meeting(meeting)
                    .employee(EmployeeMapper.INSTANCE.toEntity(employeeDto))
                    .memberType(MemberType.valueOf(memberType)) // TODO: drop-down list
                    .build();
            meetingEmployeeService.save(MeetingEmployeeMapper.INSTANCE.toDto(meetingEmployee));
        }

        return MeetingMapper.INSTANCE.toDto(meeting);
    }

    @Override
    public MeetingDto findById(Long id) {
        return MeetingMapper.INSTANCE
                .toDto(meetingRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Meeting with id=" + id + "not found")));
    }

    @Override
    public MeetingDto update(MeetingDto meetingDto) {
        return null;
    }

    @Override
    public MeetingDto save(MeetingDto meetingDto) {
        return MeetingMapper.INSTANCE
                .toDto(meetingRepository.save(MeetingMapper.INSTANCE
                        .toEntity(meetingDto)));
    }
}
