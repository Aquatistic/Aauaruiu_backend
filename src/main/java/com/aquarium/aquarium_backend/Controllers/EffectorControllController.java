package com.aquarium.aquarium_backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.EffectorControllService;
import com.aquarium.aquarium_backend.databaseTables.EffectorControll;

@RestController
@RequestMapping(path = "api/v1/effectorControll")
public class EffectorControllController {
    private final EffectorControllService effectorControllService;

    public EffectorControllController(EffectorControllService effectorControllService) {
        this.effectorControllService = effectorControllService;
    }

    @GetMapping
    public List<EffectorControll> getEffectorControll() {
        return effectorControllService.getAllEffectorControll();
    }
}
