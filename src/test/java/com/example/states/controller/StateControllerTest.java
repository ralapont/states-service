package com.example.states.controller;

import com.example.states.model.output.StateResponseDto;
import com.example.states.service.impl.StateServiceImpl;
import com.example.states.util.BuildDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StateControllerTest {

    @InjectMocks
    private StateController stateController;

    @Mock
    private StateServiceImpl stateService;

    @Test
    public void getStateTest() {

        when(stateService.getState(anyString())).thenReturn(BuildDataTest.buildState2());

        ResponseEntity<StateResponseDto> response = stateController.getStateById("AL");

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals("AL", response.getBody().getCodigo());
    }

    @Test
    public void getStatesTest() {

        when(stateService.getAllStates()).thenReturn(BuildDataTest.buildListState());

        ResponseEntity<List<StateResponseDto>> states = stateController.getAllStates();
        assertNotNull(states);
        assertNotNull(states.getBody());
        List<StateResponseDto> statesDto = states.getBody();

        assertTrue(statesDto.stream().map(StateResponseDto::getCodigo).anyMatch("AL"::equals));
        assertTrue(statesDto.stream().map(StateResponseDto::getCodigo).anyMatch("AK"::equals));
    }
}
