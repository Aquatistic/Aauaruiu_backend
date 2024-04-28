package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.AquariumService;
import com.aquarium.aquarium_backend.databaseTables.Aquarium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "api/v1/aquariums")
public class AquariumController {
    private final AquariumService aquariumService;

    @Autowired
    public AquariumController(AquariumService aquariumService) {
        this.aquariumService = aquariumService;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Aquarium>> getAquariumByUserId(@PathVariable Long userId) {
        List<Aquarium> aquariumList = aquariumService.getAllUsersAquariums(userId);
        return new ResponseEntity<>(aquariumList, HttpStatus.OK);
    }
}
