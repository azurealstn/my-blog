package com.azurealstn.myblog.repository;

import com.azurealstn.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DAO
 * 자동으로 Bean 등록이 된다.
 * @Repository
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
