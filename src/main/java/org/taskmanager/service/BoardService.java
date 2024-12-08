package org.taskmanager.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.taskmanager.model.dto.BoardCreatedDTO;
import org.taskmanager.model.entity.Account;
import org.taskmanager.model.entity.WorkSpace;
import org.taskmanager.model.enums.BoardType;
import org.taskmanager.repository.BoardRepository;
import org.taskmanager.model.entity.Board;


import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final WorkSpaceService workSpaceService;
    private final AccountService accountService;

    public void createBoard(Long workSpaceId, BoardCreatedDTO boardCreatedDTO){

        WorkSpace workSpace = workSpaceService.getWorkSpace(workSpaceId);

        Account headOfDepartment = accountService.getAccountById(boardCreatedDTO.getHeadOfDepartmentId());

        Board board = Board.builder()
                .name(boardCreatedDTO.getName())
                .department(boardCreatedDTO.getDepartment())
                .dateCreated(LocalDateTime.now())
                .workSpace(workSpace)
                .type(BoardType.valueOf(boardCreatedDTO.getType()))
                .headOfDepartment(headOfDepartment)
                .build();

        boardRepository.save(board);
    }

    public Board getBoardById(Long BoardId){
        return boardRepository.getReferenceById(BoardId);
    }

}
