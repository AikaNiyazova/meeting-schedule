package kg.megalab.meetingschedule.service;

import kg.megalab.meetingschedule.model.dto.AdminDto;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    AdminDto create(AdminDto adminDto); //TODO: CreateAdminRequest request ???

    AdminDto findById(Long id);

    AdminDto update(AdminDto adminDto);

    void save(AdminDto adminDto);

}
