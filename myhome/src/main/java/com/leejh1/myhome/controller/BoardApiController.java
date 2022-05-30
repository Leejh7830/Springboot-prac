package com.leejh1.myhome.controller;

import java.util.List;

import com.leejh1.myhome.model.Board;
import com.leejh1.myhome.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

@RestController
@RequestMapping("/api")
class boardApiController {

    @Autowired
    private BoardRepository repository;

    @GetMapping("/boards")
    List<Board> all(@RequestParam(required = false, defaultValue = "") String title,
        @RequestParam(required = false, defaultValue = "") String content) {
        if(StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
            return repository.findAll();
        } else {
            return repository.findByTitleOrContent(title, content);
//            return repository.findByTitle(title);
        }
    }

    @PostMapping("/boards")
    Board newBoard(@RequestBody Board newBoard) {
        return repository.save(newBoard);
    }

    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id) {

        return repository.findById(id).orElse(null);
    }

    @PutMapping("/boards/{id}")
    Board replaceboard(@RequestBody Board newboard, @PathVariable Long id) {

        return repository.findById(id)
                .map(board -> {
                    board.setTitle(newboard.getTitle());
                    board.setContent(newboard.getContent());
                    return repository.save(board);
                })
                .orElseGet(() -> {
                    newboard.setId(id);
                    return repository.save(newboard);
                });
    }

    @DeleteMapping("/boards/{id}")
    void deleteboard(@PathVariable Long id) {
        repository.deleteById(id);
    }
}