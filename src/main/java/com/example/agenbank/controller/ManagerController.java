package com.example.agenbank.controller;

import com.example.agenbank.entity.Manager;
import com.example.agenbank.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerController {

    ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("/manager")
    public void createManager(@RequestBody Manager manager) {
        managerService.createManager(manager);
    }

    @GetMapping("/manager/{id}")
    public Manager getManager(@PathVariable Integer id) {
        return managerService.getManagerById(id);
    }

    @GetMapping("/managers")
    public Page<Manager> getAllManager(@RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return managerService.getAllManager(pageable);
    }


}
