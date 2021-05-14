package com.azurealstn.myblog.repository;

import com.azurealstn.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * DAO
 * 자동으로 Bean 등록이 된다.
 * @Repository
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    //select * from user where username = ?;
    Optional<User> findByUsername(String username);

}

//Jpa Naming Query 전략
//전통적인 로그인 방식
//select * from user where username = ? and password = ?;
//    User findByUsernameAndPassword(String username, String password);

//    @Query(value = "select * from user where username = ? and password = ?", nativeQuery = true)
//    User login(String username, String password);
