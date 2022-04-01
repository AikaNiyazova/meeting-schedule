package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.WeekdayDto;
import org.springframework.stereotype.Service;

@Service
public interface WeekdayService {

    WeekdayDto create(WeekdayDto weekdayDto); //TODO: CreateWeekdayRequest request ???

    WeekdayDto findById(Long id);

    WeekdayDto update(WeekdayDto weekdayDto);

    void save(WeekdayDto weekdayDto);

}
