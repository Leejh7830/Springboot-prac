package com.mh.org.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class FreeBoard {
//    번호	제목	작성자	추천	조회	등록일
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "freeboard_seq",strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String name;
    private String content;

    @Column(columnDefinition = "int default 0")
    private int count;
    @Column(columnDefinition = "datetime")
    private LocalDateTime wdate;

    public FreeBoard() {}


}
