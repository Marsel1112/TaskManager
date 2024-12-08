package org.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.taskmanager.model.dto.BoardCreatedDTO;
import org.taskmanager.service.BoardService;

@RestController
@RequestMapping("/WorkSpace/{workSpaceId}/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/create")
    public void createBoard(@PathVariable Long workSpaceId, @RequestBody BoardCreatedDTO boardCreatedDTO){
        boardService.createBoard(workSpaceId,boardCreatedDTO);
    }
}
