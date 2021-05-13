package com.azurealstn.myblog.test;

import com.azurealstn.myblog.model.RoleType;
import com.azurealstn.myblog.model.User;
import com.azurealstn.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired //의존성 주입(DI)
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            return "DB 해당 id가 없어 삭제에 실패했습니다";
        }
        return "삭제되었습니다. id: " + id;
    }


    @Transactional //함수 종료시 자동 Commit이 됨.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id + " + id);
        System.out.println("password + " + requestUser.getPassword());
        System.out.println("email + " + requestUser.getEmail());

        User user = userRepository.findById(id).orElseThrow(() -> {
           return new IllegalArgumentException("수정에 실패했습니다.");
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());
//        userRepository.save(user);
        return user;
    }

    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pageUser = userRepository.findAll(pageable);

        List<User> users = pageUser.getContent();
        return users;
    }

    //{id} 주소로 파라미터를 전달받을 수 있음.
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {

        //Optional로 User 객체를 null인지 아닌지 판단해서 return
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException("해당 사용자가 없습니다.");
            }
        });
        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());
        System.out.println("email: " + user.getEmail());
        System.out.println("role: " + user.getRole());
        System.out.println("createDate " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
