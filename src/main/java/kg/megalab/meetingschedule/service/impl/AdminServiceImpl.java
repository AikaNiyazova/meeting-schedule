package kg.megalab.meetingschedule.service.impl;

import kg.megalab.meetingschedule.mapper.AdminMapper;
import kg.megalab.meetingschedule.model.dto.AdminDto;
import kg.megalab.meetingschedule.repository.AdminRepository;
import kg.megalab.meetingschedule.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminDto create(AdminDto adminDto) {
        return null;
    }

    @Override
    public AdminDto findById(Long id) {
        return AdminMapper.INSTANCE
                .toDto(adminRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Admin with id=" + id + " not found")));
    }

    @Override
    public AdminDto update(AdminDto adminDto) {
        return null;
    }

    @Override
    public AdminDto save(AdminDto adminDto) {
        return AdminMapper.INSTANCE
                .toDto(adminRepository.save(AdminMapper.INSTANCE
                        .toEntity(adminDto)));
    }
}
