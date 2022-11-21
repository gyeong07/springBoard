package com.springsession.board.controller;

import com.springsession.board.entity.crud;
import com.springsession.board.service.BoardService;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list",boardService.boardList());
        return "boardlist";
    }

    @GetMapping("/board/view") //http://localhost:8080/board/view?id=1
    public String boardView(Model model, Integer id) {
        model.addAttribute("crud", boardService.boardView(id));
        return "boardView";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){

        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/board/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id, Model model){

        model.addAttribute("crud",boardService.boardView(id));
        return "boardmodify";
    }

    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, crud crud){

        crud boardTemp = boardService.boardView(id);
        boardTemp.setTitle(crud.getTitle());
        boardTemp.setContent(crud.getContent());

        boardService.write(boardTemp);

        return "redirect:/board/list";
    }
}