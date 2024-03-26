package com.gp1.gstock.common.repository;

import com.gp1.gstock.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
