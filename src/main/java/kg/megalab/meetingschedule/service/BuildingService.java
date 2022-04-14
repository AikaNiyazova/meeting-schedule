package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.BuildingDto;
import org.springframework.stereotype.Service;

@Service
public interface BuildingService {

    BuildingDto create(BuildingDto buildingDto);

    BuildingDto findById(Long id);

    BuildingDto update(BuildingDto buildingDto);

    BuildingDto save(BuildingDto buildingDto);

}
