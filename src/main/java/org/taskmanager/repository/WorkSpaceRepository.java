package org.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.taskmanager.model.entity.WorkSpace;

public interface WorkSpaceRepository extends JpaRepository<WorkSpace, Long> {
    public WorkSpace findWorkSpaceByName(String name);
}
