package com.example.states.service;

import com.example.states.model.output.StateResponseDto;

import java.util.List;

public interface StateService {
    List<StateResponseDto> getAllStates();

    StateResponseDto getState(String codigo);
}
