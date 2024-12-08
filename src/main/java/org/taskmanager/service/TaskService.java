package org.taskmanager.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.taskmanager.model.dto.TaskCreatedDTO;
import org.taskmanager.model.entity.Board;
import org.taskmanager.model.entity.Account;
import org.taskmanager.model.entity.Task;
import org.taskmanager.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final BoardService boardService;
    private final AccountService accountService;

    public void createTask(Long boardId, TaskCreatedDTO taskCreatedDTO){
        Board board = boardService.getBoardById(boardId);

        Task task = Task.builder()
                .name(taskCreatedDTO.getName())
                .dateCreated(LocalDateTime.now())
                .content(taskCreatedDTO.getContent())
                .board(board)
                .build();

        taskRepository.save(task);
    }

    @Transactional
    public void addWorkersForTask(Long taskId, List<Long> accountIdList){
        List<Account> accountList = accountService.getAccountInList(accountIdList);

        Task task = taskRepository.getReferenceById(taskId);

        task.getAccountList().addAll(accountList);

        taskRepository.save(task);
    }

    @Transactional
    public void deleteWorkerForTask(Long taskId, Long accountId){
        Task task = taskRepository.getReferenceById(taskId);


    }

}
