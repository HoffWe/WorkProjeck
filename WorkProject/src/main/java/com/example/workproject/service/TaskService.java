package com.example.workproject.service;

import com.example.workproject.dto.TaskDtoIn;
import com.example.workproject.model.Message;
import com.example.workproject.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task add(TaskDtoIn newTask);
    Optional<Task> findById(long taskId);
    List<Task> findByExecutorId(long workerId);

    Task update (Task updatedTask);
    void deleteById(long id);
}
