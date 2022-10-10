package com.example.workproject.service;


import com.example.workproject.dto.WorkerDto;
import com.example.workproject.model.Worker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WorkerService {
    Worker add (WorkerDto workerDto);
    Optional<Worker> findById(long workerId);
    List<Worker> findAll();
    void delete (long workerId);


}
