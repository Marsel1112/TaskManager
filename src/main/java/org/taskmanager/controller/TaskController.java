package org.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.taskmanager.model.dto.TaskCreatedDTO;
import org.taskmanager.service.TaskService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/WorkSpace/{workSpaceId}/boards/{boardId}/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public void createTask(@PathVariable Long boardId, @RequestBody TaskCreatedDTO taskCreatedDTO){
        taskService.createTask(boardId,taskCreatedDTO);
    }

    @PutMapping("/{taskId}/addWorkers")
    public void addWorkersForTask(@PathVariable Long taskId, @RequestBody List<Long> accountIdList){
        taskService.addWorkersForTask(taskId,accountIdList);
    }

    @DeleteMapping("/{taskId}/deleteWorker")
    public void deleteWorkerForTask(@PathVariable Long taskId, @RequestBody Map<String, Long> payload){
        Long workerId = payload.get("ïd");
        taskService.deleteWorkerForTask(taskId,workerId);
    }

}
