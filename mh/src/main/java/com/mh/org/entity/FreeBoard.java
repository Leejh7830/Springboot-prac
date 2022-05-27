package com.mh.org.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class FreeBoard {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(generator = "freeboard_seq",strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String name;
    private String count;

    @Column(columnDefinition = "datetime default now()")
    private LocalDateTime wdate;


    public FreeBoard() {}
}
