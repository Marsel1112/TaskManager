package org.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.model.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
