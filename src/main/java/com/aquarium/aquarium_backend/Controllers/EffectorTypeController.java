package com.aquarium.aquarium_backend.Controllers;

import com.aquarium.aquarium_backend.Services.EffectorTypeService;
import com.aquarium.aquarium_backend.databaseTables.EffectorType;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/effectorType")
public class EffectorTypeController {
  private final EffectorTypeService effectorTypeService;




  public EffectorTypeController(EffectorTypeService effectorTypeService) {

    this.effectorTypeService = effectorTypeService;
  }

  @GetMapping
  public ResponseEntity<List<EffectorType>> getAllEffectorTypes() {
    List<EffectorType> allEffectorList = effectorTypeService.getAllEffectorTypes();

    return new ResponseEntity<>(allEffectorList, HttpStatus.OK);
  }

}
