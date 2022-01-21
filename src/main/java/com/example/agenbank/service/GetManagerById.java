package com.example.agenbank.service;

import com.example.agenbank.model.entity.Manager;
import com.example.agenbank.repository.ManagerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GetManagerById {

    ManagerRepository managerRepository;

    public GetManagerById(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public Manager execute(Integer id) {
        if (!managerRepository.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manager with id:"+id+" is not exist");
        }
        return managerRepository.findById(id).get();
    }

}
