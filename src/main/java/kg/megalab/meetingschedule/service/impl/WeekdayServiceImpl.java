package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.WeekdayMapper;
import kg.megalab.meetingschedule.model.dto.WeekdayDto;
import kg.megalab.meetingschedule.repository.WeekdayRepository;
import kg.megalab.meetingschedule.service.WeekdayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class WeekdayServiceImpl implements WeekdayService {

    private final WeekdayRepository weekdayRepository;

    @Autowired
    public WeekdayServiceImpl(WeekdayRepository weekdayRepository) {
        this.weekdayRepository = weekdayRepository;
    }

    @Override
    public WeekdayDto create(WeekdayDto weekdayDto) {
        return null;
    }

    @Override
    public WeekdayDto findById(Long id) {
        return WeekdayMapper.INSTANCE
                .toDto(weekdayRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Weekday with id=" + id + "not found")));
    }

    @Override
    public WeekdayDto update(WeekdayDto weekdayDto) {
        return null;
    }

    @Override
    public WeekdayDto save(WeekdayDto weekdayDto) {
        return WeekdayMapper.INSTANCE
                .toDto(weekdayRepository.save(WeekdayMapper.INSTANCE
                        .toEntity(weekdayDto)));
    }
}
