package com.example.states.controller;

import com.example.states.model.output.StateResponseDto;
import com.example.states.service.impl.StateServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080"})
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class StateController {

    private final StateServiceImpl stateService;

    @GetMapping("/states/{codigo}")
    public ResponseEntity<StateResponseDto> getStateById(@PathVariable String codigo) {

        return ResponseEntity.ok(stateService.getState(codigo));
    }

    @GetMapping("/states")
    public ResponseEntity<List<StateResponseDto>> getAllStates() {

        return ResponseEntity.ok(stateService.getAllStates());
    }
}
