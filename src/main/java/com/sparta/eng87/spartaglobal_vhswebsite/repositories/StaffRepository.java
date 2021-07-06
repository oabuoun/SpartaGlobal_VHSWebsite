package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {
}
