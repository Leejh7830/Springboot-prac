package com.mh.org.validator;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class FreeBoardDto {
    private Long id;

    @NotEmpty(message = "제목 입력하세요")
    private String title;

    @NotEmpty(message = "작성자 입력하세요")
    private String name;
    @NotEmpty(message = "내용 입력하세요")
    private String cotent;

    private int count;
    private LocalDateTime wdate;


    public FreeBoardDto() {}
}
