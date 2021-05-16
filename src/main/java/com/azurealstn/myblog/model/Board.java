package com.azurealstn.myblog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터일 때 사용
    private String content;

    private int count; //조회수

    @ManyToOne //Board : User -> Many : One, 관계 설정
    @JoinColumn(name = "userId") //필드명
    private User user; //두 테이블을 조인해서 FK 생성

    @OrderBy("id desc")
    @JsonIgnoreProperties({"board"})
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) //MappedBy: 연관관계의 주인이 아니다.(난 FK가 아니다.) DB에 컬럼을 만들면 안된다.
    private List<Reply> replies;

    @CreationTimestamp
    private LocalDateTime createDate;
}
