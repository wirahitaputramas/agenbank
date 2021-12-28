package com.example.agenbank.service;

import com.example.agenbank.entity.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ManagerService {
    public void createManager(Manager manager);
    public Manager getManagerById(Integer id);
    public Page<Manager> getAllManager(Pageable pageable);
    public void removeManagerById(Integer id);
}
