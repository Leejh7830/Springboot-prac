package com.example.member.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
public class MemberFormDto {

    private Long id;

    @NotEmpty(message = "이메일 입력하세요...") // pom.xml에 validation 디펜던시 추가
    @Email
    private String email;

    @NotEmpty(message = "이름 입력하세요...")
    private String name;

    @NotEmpty(message = "성별 입력하세요...")
    private String gender;

    @NotEmpty(message = "패스워드 입력하세요...")
    private String password;
}
