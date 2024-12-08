package org.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.model.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
