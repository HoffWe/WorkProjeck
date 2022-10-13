package com.example.workproject.controller;


import com.example.workproject.dto.TaskDtoIn;
import com.example.workproject.dto.TaskDtoOut;
import com.example.workproject.mapper.TaskToDto;
import com.example.workproject.model.Task;
import com.example.workproject.service.JpaTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/task")
public class TaskController {

    private final JpaTaskService taskService;

    public TaskController(JpaTaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping
    public ResponseEntity<String> add(@RequestBody TaskDtoIn taskDtoIn){
        final Task task = taskService.add(taskDtoIn);
        return ResponseEntity.status(HttpStatus.CREATED).body("Wiadomość pomyślnie wysłana");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDtoOut> get (@PathVariable long id){
        final Optional<Task> optionalTask = taskService.findById(id);
        return optionalTask.map(task -> ResponseEntity.ok(TaskToDto.mapToDto(task))).orElse(ResponseEntity.of(Optional.empty()));
    }

    @GetMapping("/workerTasks/{id}")
    public List<TaskDtoOut> findByExecutorId (@PathVariable long id){
        return taskService.findByExecutorId(id)
                .stream().map(TaskToDto::mapToDto)
                .collect(Collectors.toList());
    }


}
