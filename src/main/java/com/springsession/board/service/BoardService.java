package com.springsession.board.service;

import com.springsession.board.entity.crud;
import com.springsession.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    //글 작성
    @Autowired
    private BoardRepository boardRepository;

    public void write(crud crud) {
        boardRepository.save(crud);
    }

    //게시물 리스트 처리
    public List<crud> boardList() {
        return boardRepository.findAll();
    }

    //특정 게시물 불러오기
    public crud boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}