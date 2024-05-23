package com.aquarium.aquarium_backend.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.EffectorControllService;
import com.aquarium.aquarium_backend.databaseTables.EffectorControll;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path = "api/v1/effectorControll")
public class EffectorControllController {
    private final EffectorControllService effectorControllService;

    public EffectorControllController(EffectorControllService effectorControllService) {
        this.effectorControllService = effectorControllService;
    }

    @GetMapping
    public ResponseEntity<List<EffectorControll>> getEffectorControll() {
        return new ResponseEntity<>(effectorControllService.getAllEffectorControll(), HttpStatus.OK);
    }

    @GetMapping("/userEffector/{effectorId}")
    public ResponseEntity<List<EffectorControll>> getEffectorControls(@PathVariable Long effectorId) {
        return new ResponseEntity<>(effectorControllService.getEffectorControlsByEffectorId(effectorId), HttpStatus.OK);
    }

}
