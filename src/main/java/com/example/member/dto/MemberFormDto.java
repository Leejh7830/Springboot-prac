package com.example.member.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class MemberFormDto {

    private Long id;

    @NotEmpty // pom.xml에 validation 디펜던시 추가
    private String email;

    private String name;
    private String gender;
    private String password;
}
