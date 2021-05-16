package com.azurealstn.myblog.service;

import com.azurealstn.myblog.model.RoleType;
import com.azurealstn.myblog.model.User;
import com.azurealstn.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional(readOnly = true)
    public User userFind(String username) {
        User user = userRepository.findByUsername(username).orElseGet(() -> {
            return new User();
        });
        return user;
    }

    @Transactional
    public void userJoin(User user) {
        String rawPassword = user.getPassword(); //원래 비밀번호
        String encPassword = encoder.encode(rawPassword); //해쉬 비밀번호
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }

    @Transactional
    public void userUpdate(User user) {
        //수정시에는 영속성 컨텍스트에 User를 영속화시키고, 영속화된 User를 수정
        User persistence = userRepository.findById(user.getId()).orElseThrow(() -> {
            return new IllegalArgumentException("회원 찾기 실패");
        });

        //validation 체크 (kakao는 비밀번호, 이메일 수정 불가)
        if (persistence.getOauth() == null || persistence.getOauth().equals("")) {
            String rawPassword = user.getPassword();
            String encPassword = encoder.encode(rawPassword); //비밀번호 암호화
            persistence.setPassword(encPassword);
            persistence.setEmail(user.getEmail());
        }

    }

    /*
    //전통적인 로그인 방식
    @Transactional(readOnly = true)
    public User userLogin(User user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
    */
}
