package com.example.workproject.service;

import com.example.workproject.dto.WorkerDto;
import com.example.workproject.model.Worker;
import com.example.workproject.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaWorkerService implements WorkerService{

    private final WorkerRepository workerRepository;

    public JpaWorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker add(WorkerDto workerDto) {
        Worker worker = Worker.builder()
                .name(workerDto.getName())
                .lastName(workerDto.getLastName())
                .eMail(workerDto.getEMail())
                .password(workerDto.getPassword())
                .build();
        return workerRepository.save(worker);
    }

    @Override
    public Optional<Worker> findById(long workerId) {
        return workerRepository.findById(workerId);
    }

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public void delete(long workerId) {

    }
}
