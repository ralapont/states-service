package com.example.states.repository;

import com.example.states.entity.StateEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class StateRepositoryTest {

    @Autowired
    private StateRepository stateRepository;

    @Test
    @Sql({ "classpath:insert_gets.sql" })
    public void findAllTest() {

        List<StateEntity> states = stateRepository.findAll();
        assertNotNull(states);

        assertTrue(states.stream().map(StateEntity::getCodigo).anyMatch("AL"::equals));
        assertTrue(states.stream().map(StateEntity::getCodigo).anyMatch("AK"::equals));
    }

    @Test
    @Sql({ "classpath:insert_gets.sql" })
    public void findByPkTest() {

        Optional<StateEntity> stateOp = stateRepository.findById("AK");
        assertFalse(stateOp.isEmpty());
        StateEntity state = stateOp.get();
        assertEquals("AK", state.getCodigo());
    }

    }
