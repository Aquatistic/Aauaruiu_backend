package com.aquarium.aquarium_backend.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.EffectorTypeService;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;

@RestController
@RequestMapping(path = "api/v1/effectorType")
public class EffectorTypeController {
    private final EffectorTypeService effectorTypeService;

    public EffectorTypeController(EffectorTypeService effectorTypeService) {
        this.effectorTypeService = effectorTypeService;
    }

    @GetMapping
    public List<EffectorType> getAllEffectorTypes() {
        return effectorTypeService.getAllEffectorTypes();
    }
}
