package com.example.workproject.controller;


import com.example.workproject.dto.WorkerDto;
import com.example.workproject.dto.WorkerDtoOut;
import com.example.workproject.mapper.WorkerToDto;
import com.example.workproject.model.Worker;
import com.example.workproject.service.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody WorkerDto workerDto){
        final Worker worker = workerService.add(workerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dodano pomyślnie");
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDtoOut> findById(@PathVariable long id){
        final Optional<Worker> optionalWorker = workerService.findById(id);
        return optionalWorker.map(worker -> ResponseEntity.ok(WorkerToDto.mapToDto(worker))).orElse(ResponseEntity.of(Optional.empty()));
    }

    @GetMapping("/all")
    public List<WorkerDtoOut> findAll() {
        return workerService.findAll().stream()
                .map(WorkerToDto::mapToDto)
                .collect(Collectors.toList());
    }
}
