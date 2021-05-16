package com.azurealstn.myblog.repository;

import com.azurealstn.myblog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
