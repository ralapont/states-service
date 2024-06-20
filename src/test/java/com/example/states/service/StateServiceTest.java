package com.example.states.service;

import com.example.states.exception.StateNotFoundException;
import com.example.states.mappers.ConvertDtoResponseEntity;
import com.example.states.model.output.StateResponseDto;
import com.example.states.repository.StateRepository;
import com.example.states.service.impl.StateServiceImpl;
import com.example.states.util.BuildDataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StateServiceTest {

    @InjectMocks
    StateServiceImpl stateService;

    @Mock
    StateRepository stateRepository;

    @Mock
    ConvertDtoResponseEntity convertDtoResponseEntity;

    @Test
    void getAllStatesTest() {

        when(stateRepository.findAll()).thenReturn(BuildDataTest.buildListStateEntity());
        when(convertDtoResponseEntity.mapperEntityToDto(BuildDataTest.buildEntaty1())).thenReturn(BuildDataTest.buildState2());
        when(convertDtoResponseEntity.mapperEntityToDto(BuildDataTest.buildEntaty2())).thenReturn(BuildDataTest.buildState1());

        List<StateResponseDto> states = stateService.getAllStates();
        assertNotNull(states);
        assertEquals(2, states.size());

        assertTrue(states.stream().map(StateResponseDto::getCodigo).anyMatch("AL"::equals));
        assertTrue(states.stream().map(StateResponseDto::getCodigo).anyMatch("AK"::equals));
    }

    @Test
    void getStateTest() {

        when(stateRepository.findById("AK")).thenReturn(Optional.of(BuildDataTest.buildEntaty2()));
        when(convertDtoResponseEntity.mapperEntityToDto(BuildDataTest.buildEntaty2())).thenReturn(BuildDataTest.buildState1());

        StateResponseDto state = stateService.getState("AK");
        assertNotNull(state);
        assertEquals("AK", state.getCodigo());
    }

    @Test
    void exceptionNotFoundTest() {

        when(stateRepository.findById("AT")).thenReturn(Optional.empty());

        StateNotFoundException thrown = assertThrows(StateNotFoundException.class, () -> {
            StateResponseDto state = stateService.getState("AT");
        }, "State with id AT not found");

    }

}
