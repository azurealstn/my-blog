package com.azurealstn.myblog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    @ManyToOne //Reply : Board -> Many : One
    @JoinColumn(name = "boardId")
    private Board board; //한 게시글의 여러 댓글 연관관계

    @ManyToOne //Reply : User -> Many : One
    @JoinColumn(name = "userId")
    private User user; //누가 댓글을 달았는지

    @CreationTimestamp
    private Timestamp createDate;
}
