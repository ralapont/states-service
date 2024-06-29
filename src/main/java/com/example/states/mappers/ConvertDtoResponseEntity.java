package com.example.states.mappers;

import com.example.states.entity.StateEntity;
import com.example.states.model.output.StateResponseDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConvertDtoResponseEntity {

    private final ModelMapper modelMapper;

    public StateResponseDto mapperEntityToDto(StateEntity stateEntity) {
        return modelMapper.map(stateEntity, StateResponseDto.class);
    }
}
