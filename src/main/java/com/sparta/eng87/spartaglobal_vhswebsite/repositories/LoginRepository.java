package com.sparta.eng87.spartaglobal_vhswebsite.repositories;

import com.sparta.eng87.spartaglobal_vhswebsite.entities.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Integer> {

    @Query(value = "SELECT customer_id FROM login_entity WHERE user_name = ?", nativeQuery = true)
    Integer findCustomerIdByUsername (String username);

}
