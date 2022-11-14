package com.springsession.board.repository;

import com.springsession.board.entity.crud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<crud,Integer> {
}