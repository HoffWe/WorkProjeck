package com.example.workproject.repository;

import com.example.workproject.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

    List<Task> findByExecutorId(long workerId);


}
