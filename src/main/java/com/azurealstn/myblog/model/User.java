package com.azurealstn.myblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
//@DynamicInsert //insert시 null인 필드를 제외시킨다.
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; //시퀀스(oracle), auto_increment(mysql)

    @Column(nullable = false, length = 30, unique = true)
    private String username; //id

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //@ColumnDefault("'user'") //개발자가 실수할 수도 있기 때문에 사용X
    //DB는 RoleType이 없기 때문에 String으로 변환주어야 한다.
    @Enumerated(EnumType.STRING)
    private RoleType role; //Enum을 쓰는 것이 좋다. {admin, user}

    @CreationTimestamp //시간 자동입력
    private Timestamp createDate;
}
