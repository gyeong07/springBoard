package com.springsession.board.controller;

import com.springsession.board.entity.crud;
import com.springsession.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String main() {
        return "boardwrite";
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(crud crud) {
        boardService.write(crud);
        return "";
    }
}