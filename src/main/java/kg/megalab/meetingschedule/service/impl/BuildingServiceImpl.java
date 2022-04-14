package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.BuildingMapper;
import kg.megalab.meetingschedule.model.dto.BuildingDto;
import kg.megalab.meetingschedule.repository.BuildingRepository;
import kg.megalab.meetingschedule.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class BuildingServiceImpl implements BuildingService {

    private final BuildingRepository buildingRepository;

    @Autowired
    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    public BuildingDto create(BuildingDto buildingDto) {
        return null;
    }

    @Override
    public BuildingDto findById(Long id) {
        return BuildingMapper.INSTANCE
                .toDto(buildingRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Building with id=" + id + "not found")));
    }

    @Override
    public BuildingDto update(BuildingDto buildingDto) {
        return null;
    }

    @Override
    public BuildingDto save(BuildingDto buildingDto) {
        return BuildingMapper.INSTANCE
                .toDto(buildingRepository.save(BuildingMapper.INSTANCE
                        .toEntity(buildingDto)));
    }
}
