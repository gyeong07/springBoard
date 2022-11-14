package com.springsession.board.service;

import com.springsession.board.entity.crud;
import com.springsession.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public void write(crud crud) {
        boardRepository.save(crud);
    }
}