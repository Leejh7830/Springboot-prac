package com.rest.api.controller;

import com.rest.api.cont.StatusEnum;
import com.rest.api.entity.Board;
import com.rest.api.message.Message;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
public class BoardController {

    // localhost:8080/api/boards/1/10
    // localhost:8080/api/boards/{page}/{number}
    @GetMapping("boards")
    @CrossOrigin
    public ResponseEntity<Message> boards() {

        List<Board> list = Arrays.asList(
                new Board(1L,"제목입니다11","220519","내용1",0),
                new Board(2L,"제목22","220519","내용2",0),
                new Board(3L,"제목33","220519","내용3",0),
                new Board(4L,"제목44","220519","내용4",0)
        );

        Message message = new Message();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application",
                                "json",
                                Charset.forName("UTF-8")));
        message.setStatus(StatusEnum.OK);
        message.setMessage("성공");
        message.setData(list);
        return new ResponseEntity<>(message,headers, HttpStatus.OK);
    }
}
