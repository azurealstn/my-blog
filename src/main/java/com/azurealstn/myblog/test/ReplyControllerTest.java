package com.azurealstn.myblog.test;

import com.azurealstn.myblog.model.Board;
import com.azurealstn.myblog.model.Reply;
import com.azurealstn.myblog.repository.BoardRepository;
import com.azurealstn.myblog.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReplyControllerTest {

    @Autowired
    private ReplyRepository repository;

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/test/board/{id}")
    public Board getBoard(@PathVariable int id) {
        return boardRepository.findById(id).get();
    }

    @GetMapping("/test/reply")
    public List<Reply> getReply() {
        return repository.findAll();
    }
}
