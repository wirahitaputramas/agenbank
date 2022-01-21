package com.example.agenbank.controller;

import com.example.agenbank.model.entity.Manager;
import com.example.agenbank.service.GetAllManager;
import com.example.agenbank.service.GetAllManagerName;
import com.example.agenbank.service.GetManagerById;
import com.example.agenbank.service.PostManagerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    PostManagerService postManagerService;
    GetManagerById getManagerById;
    GetAllManager getAllManager;
    GetAllManagerName getAllManagerName;

    public ManagerController(PostManagerService postManagerService,
                             GetManagerById getManagerById,
                             GetAllManager getAllManager,
                             GetAllManagerName getAllManagerName) {
        this.postManagerService = postManagerService;
        this.getManagerById = getManagerById;
        this.getAllManager = getAllManager;
        this.getAllManagerName = getAllManagerName;
    }

    @PostMapping("/manager")
    public void createManager(@RequestBody Manager manager) {
        postManagerService.execute(manager);
    }

    @GetMapping("/manager/{id}")
    public Manager getManager(@PathVariable Integer id) {
        return getManagerById.execute(id);
    }

    @GetMapping("/managers")
    public Page<Manager> getAllManager(@RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return getAllManager.execute(pageable);
    }

    @GetMapping("/managers-name")
    public List<String> getAllManagerName(){
        return getAllManagerName.execute();
    }


}
