package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
