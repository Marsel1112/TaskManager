package org.taskmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.taskmanager.service.WorkSpaceService;

import java.util.Map;

@RestController
@RequestMapping("/WorkSpace")
@RequiredArgsConstructor
public class WorkSpaceController {
    private final WorkSpaceService workSpaceServiceService;

    @PostMapping("/create")
    public void createWorkSpace(@RequestBody Map<String, String> payload){
        String name = payload.get("name");

        workSpaceServiceService.createWorkSpace(name);
    }

    @PostMapping("/{id}")
    public void archiveTheWorkSpace(@PathVariable Long id){
        workSpaceServiceService.archiveTheWorkSpace(id);
    }

    @PostMapping
    public void returnArchivedWorkSpace(@RequestBody Map<String, Long> payload){
        workSpaceServiceService.returnArchivedWorkSpace(payload.get("id"));
    }

    @PutMapping("/{id}")
    public void renameWorkSpace(@PathVariable Long id,@RequestBody Map<String, String> payload){
        String name = payload.get("name");
        workSpaceServiceService.renameWorkSpace(id,name);
    }


}
