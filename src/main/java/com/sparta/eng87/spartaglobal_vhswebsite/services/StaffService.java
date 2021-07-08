package com.sparta.eng87.spartaglobal_vhswebsite.services;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.StaffEntity;
import com.sparta.eng87.spartaglobal_vhswebsite.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    private StaffRepository staffRepository;

    @Autowired
    public StaffService (StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public void save (StaffEntity staffEntity) {
        staffRepository.save(staffEntity);
    }
}
