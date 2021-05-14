package com.azurealstn.myblog.repository;

import com.azurealstn.myblog.model.Board;
import com.azurealstn.myblog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
