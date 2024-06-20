package com.example.states.service.impl;

import com.example.states.entity.StateEntity;
import com.example.states.exception.StateNotFoundException;
import com.example.states.mappers.ConvertDtoResponseEntity;
import com.example.states.model.output.StateResponseDto;
import com.example.states.repository.StateRepository;
import com.example.states.service.StateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;
    private final ConvertDtoResponseEntity convertDtoResponseEntity;

    @Override
    public List<StateResponseDto> getAllStates() {
        List<StateEntity> entities = stateRepository.findAll();

        return entities.stream()
                .map(convertDtoResponseEntity::mapperEntityToDto)
                .toList();
    }

    @Override
    public StateResponseDto getState(String codigo) {
        Optional<StateEntity> entityOptional = stateRepository.findById(codigo);
        if (entityOptional.isPresent()) {
            StateEntity entity = entityOptional.get();
            return convertDtoResponseEntity.mapperEntityToDto(entity);
        } else {
            throw new StateNotFoundException(codigo);
        }

    }
}
