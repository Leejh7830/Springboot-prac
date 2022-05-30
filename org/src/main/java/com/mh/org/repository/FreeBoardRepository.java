package com.mh.org.repository;

import com.mh.org.entity.FreeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FreeBoardRepository extends JpaRepository<FreeBoard,Long> {


    public Page<FreeBoard> findByTitleContainingIgnoreCase(String title);
    // (위)쿼리생성 findBy찾고싶은Containing대소문자무시
    // (아래)직접 쿼리설정
    @Query(value = "select * from free_board where title like '$:title%' " +
            "\n#pageable\n", nativeQuery = true)
    public Page<FreeBoard> mycustomQuery(String title, Pageable pa);



}
