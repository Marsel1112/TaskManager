package org.taskmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.taskmanager.model.entity.WorkSpace;
import org.taskmanager.model.enums.WorkSpaceType;
import org.taskmanager.repository.WorkSpaceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkSpaceService {
    private final WorkSpaceRepository workSpaceRepository;

    public void createWorkSpace(String name){
        workSpaceRepository.save(WorkSpace.builder()
                                    .name(name)
                                    .dateCreated(LocalDateTime.now())
                                    .type(WorkSpaceType.ACTIVE)
                                    .build());
    }

    public void archiveTheWorkSpace(Long id){
        WorkSpace workSpace = workSpaceRepository.getReferenceById(id);

        workSpace.setType(WorkSpaceType.ARCHIVED);

        workSpaceRepository.save(workSpace);
    }

    public void returnArchivedWorkSpace(Long id){
        WorkSpace workSpace = workSpaceRepository.getReferenceById(id);

        workSpace.setType(WorkSpaceType.ACTIVE);

        workSpaceRepository.save(workSpace);
    }

    public void renameWorkSpace(Long id, String name){
        WorkSpace workSpace =workSpaceRepository.getReferenceById(id);

        workSpace.setName(name);

        workSpaceRepository.save(workSpace);
    }

    public List<WorkSpace> getAlWorkSpace(){
        return workSpaceRepository.findAll();
    }

    public WorkSpace getWorkSpace(Long id){
        return workSpaceRepository.getReferenceById(id);
    }

    public WorkSpace getWorkSpace(String name){
        return workSpaceRepository.findWorkSpaceByName(name);
    }
}
