package com.example.states.mappers;

import com.example.states.model.output.StateResponseDto;
import com.example.states.util.BuildDataTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@AllArgsConstructor
public class ConvertDtoResponseEntityTest {

    @Autowired
    private ConvertDtoResponseEntity convertDtoResponseEntity;

    @Test
    void mapperEntityToDtoTest() {

        StateResponseDto dto = convertDtoResponseEntity.mapperEntityToDto(BuildDataTest.buildEntaty1());

        assertNotNull(dto);
    }
}
