package com.example.agenbank.service;

import com.example.agenbank.entity.Manager;
import com.example.agenbank.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ManagerServiceDBImpl implements ManagerService{

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public void createManager(Manager manager) {
        managerRepository.save(manager);
    }

    @Override
    public Manager getManagerById(Integer id) {
        if (!managerRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager with id:"+id+" is not exist");
        }
        return managerRepository.findById(id).get();
    }

    @Override
    public Page<Manager> getAllManager(Pageable pageable) {
        return managerRepository.findAll(pageable);
    }

    @Override
    public void removeManagerById(Integer id) {

    }
}
