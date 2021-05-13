package com.azurealstn.myblog.repository;

import com.azurealstn.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * DAO
 * 자동으로 Bean 등록이 된다.
 * @Repository
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    //Jpa Naming Query 전략
    //select * from user where username = ? and password = ?;
    User findByUsernameAndPassword(String username, String password);

//    @Query(value = "select * from user where username = ? and password = ?", nativeQuery = true)
//    User login(String username, String password);
}
