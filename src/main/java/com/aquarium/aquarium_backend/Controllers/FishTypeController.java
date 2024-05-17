package com.aquarium.aquarium_backend.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquarium.aquarium_backend.Services.FishTypeService;
import com.aquarium.aquarium_backend.databaseTables.FishType;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "api/v1/fishType")
public class FishTypeController {
  private final FishTypeService fishTypeService;

  public FishTypeController(FishTypeService fishTypeService) {
    this.fishTypeService = fishTypeService;
  }

  @GetMapping
  public List<FishType> getMethodName() {
    return fishTypeService.getAllFishTypes();
  }
}
