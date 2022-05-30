package com.leejh1.myhome.repository;


import com.leejh1.myhome.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByTitle(String title); // 제목검색
    List<Board> findByTitleOrContent(String title, String content); // 제목&내용 검색
}