package com.azurealstn.myblog.test;

import org.springframework.web.bind.annotation.*;

/**
 * 사용자 요청 -> 응답(HTML 파일)
 * @Controller
 * 시용자 요청 -> 응답(Data)
 * @RestController
 *
 * 인터넷 브라우저 요청은 무조건 get 요청만 가능하다.
 */
@RestController
public class HttpControllerTest {

    public static final String TAG = "HttpControllerTest: ";

    @GetMapping("/http/lombok")
    public String lombokTest() {
        Member m = Member.builder()
                .username("azure")
                .password("1234")
                .email("azure@naver.com")
                .build();
        System.out.println(TAG + "getter " + m.getUsername());
        m.setUsername("second");
        System.out.println(TAG + "setter " + m.getUsername());

        return "lombok test 완료";
    }

    @GetMapping("/http/get")
    public String getTest(Member m) {
        return "get 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PostMapping("/http/post")
    public String postTest(@RequestBody Member m) {
        return "post 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청: " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
