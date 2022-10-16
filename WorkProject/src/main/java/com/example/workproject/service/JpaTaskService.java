package com.example.workproject.service;

import com.example.workproject.dto.TaskDtoIn;
import com.example.workproject.model.Message;
import com.example.workproject.model.Task;
import com.example.workproject.repository.MessageRepository;
import com.example.workproject.repository.TaskRepository;
import com.example.workproject.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JpaTaskService implements TaskService{

    private final TaskRepository taskRepository;
    private final WorkerRepository workerRepository;
    private final MessageRepository messageRepository;

    public JpaTaskService(TaskRepository taskRepository, WorkerRepository workerRepository, MessageRepository messageRepository) {
        this.taskRepository = taskRepository;
        this.workerRepository = workerRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public Task add(TaskDtoIn newTask) {
        Task task = Task.builder()
                .title(newTask.getTitle())
                .issueDate(LocalDateTime.now())
                .deadLine(newTask.getFinishDate())
                .isFinished(false)
                .executor(workerRepository.getReferenceById(newTask.getExecutorId()))
                .message(messageRepository.getReferenceById(newTask.getMessageId()))
                .build();
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> findById(long taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public List<Task> findByExecutorId(long workerId) {
        return taskRepository.findByExecutorId(workerId);
    }

    @Override
    public Task update (Task updatedTask) {
        return taskRepository.save(updatedTask);
    }


    @Override
    public void deleteById(long id) {
        taskRepository.deleteById(id);
    }
}
